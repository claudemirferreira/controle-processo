package br.com.ss.agile.controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.alfresco.repo.webservice.administration.AdministrationFault;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.StreamedContent;

import br.com.ss.agile.dominio.Documento;
import br.com.ss.agile.dominio.VariaveisRequerimento;
import br.com.ss.agile.util.UtilUrl;
import br.fucapi.bpms.activiti.dominio.TarefaInstancia;
import br.fucapi.bpms.activiti.servico.ActivitiServico;
import br.fucapi.bpms.alfresco.dominio.GrupoAlfresco;
import br.fucapi.bpms.alfresco.dominio.Usuario;
import br.fucapi.bpms.alfresco.servico.AlfrescoServico;

@ManagedBean
@SessionScoped
public class TarefaControlador implements Serializable {

	private static final long serialVersionUID = -8945105181334276134L;

	@ManagedProperty(value = "#{activitiServicoImpl}")
	private ActivitiServico activitiServico;

	@ManagedProperty(value = "#{alfrescoServicoImpl}")
	private AlfrescoServico alfrescoServico;

	private VariaveisRequerimento variaveisRequerimento = new VariaveisRequerimento();

	private boolean status;

	private boolean proprietario = false;

	private GrupoAlfresco grupo = null;

	private StreamedContent file;

	private Usuario usuario;

	private Usuario usuarioLogado;

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	private TarefaInstancia entity;

	private List<TarefaInstancia> lista = new ArrayList<TarefaInstancia>();

	private String imagem;

	private Documento documento;

	private List<Documento> documentos;

	@ManagedProperty(value = "#{bpmswebproperties}")
	private Properties bpmswebproperties;

	public String init() {

//		this.usuarioLogado = (Usuario) FacesContext.getCurrentInstance()
//				.getExternalContext().getSessionMap().get("usuarioLogado");

		this.usuarioLogado = new Usuario();
		
		this.usuarioLogado.setUserName("admin");
		
		this.usuario = this.usuarioLogado;

		pesquisar();

		List<GrupoAlfresco> grupos;
		try {
			grupos = alfrescoServico.listarGruposPorUsuario(usuario
					.getUserName());

			// verificar se o usuario é adminstrador
			for (GrupoAlfresco grupoAlfresco : grupos) {
				if (grupoAlfresco.getDisplayName().equals("REVISOR_APROVADOR")) {
					grupo = grupoAlfresco;
					break;
				}
			}

		} catch (AdministrationFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		this.usuarios = alfrescoServico.getUsuarios();
		this.usuario = new Usuario();

		return UtilUrl.getRequerimentoPesquisaTarefaUrl();
	}

	public void pesquisar() {

		if (this.usuario.getUserName().equals("TODOS"))
			this.lista = activitiServico.getTodasTarefas();

		else
			this.lista = activitiServico.getTarefasUsuario(this.usuario
					.getUserName());

		this.variaveisRequerimento = null;

		for (TarefaInstancia tarefaInstancia : this.lista) {
			this.variaveisRequerimento = new VariaveisRequerimento();
			this.variaveisRequerimento
					.converterListaVariaveisParaVariaveisProcesso(tarefaInstancia
							.getVariables());
			tarefaInstancia.setVariaveisProcesso(this.variaveisRequerimento);

		}

		validarProprietario();
	}

	public String parecer(TarefaInstancia entity) {
		this.variaveisRequerimento.setParecer("");
		this.entity = entity;

		System.out.println(UtilUrl.getUrl(entity.getTaskDefinitionKey()));

		return UtilUrl.getUrl(entity.getTaskDefinitionKey());
	}

	public String telaSearch() {
		return "/pages/tarefa/search.xhtml";
	}

	public String aprovar() {

		String json = "{\"name\":\"status\", \"value\":true},"
				+ "{\"name\":\"parecer\", \"value\":\""
				+ this.variaveisRequerimento.getParecer() + "\"}";
		System.out.println(this.entity.getId());
		System.out.println(json);
		String result = activitiServico.completarTarefa(this.entity.getId(),
				json);
		System.out.println(result);

		this.usuario.setUserName(this.entity.getAssignee());
		// atualiza a lista de tarefas pendentes
		pesquisar();

		return UtilUrl.getRequerimentoPesquisaTarefaUrl();
	}

	public String reprovar() {
		String json = "{\"name\":\"status\", \"value\":false},"
				+ "{\"name\":\"parecer\", \"value\":\""
				+ this.variaveisRequerimento.getParecer() + "\"}";
		String result = activitiServico.completarTarefa(this.entity.getId(),
				json);
		System.out.println(result);
		pesquisar();
		return UtilUrl.getRequerimentoPesquisaTarefaUrl();
	}

	public String completarTarefaNative() {
		// String result = activitiServico.completarTarefaNative();
		//
		// System.out.println(result);
		pesquisar();
		return "/pages/tarefa/search.xhtml";
	}

	// metodo responsavel por retornar a url da imagem do processo
	public void abrirImagemProcesso(TarefaInstancia entity) {

		this.entity = entity;
		setImagem(activitiServico.getProcessoDiagrama(entity
				.getProcessInstanceId()));

	}

	public void anexarArquivosAlfresco() {
		try {
			String uuid = null;

			String nomePasta = this.variaveisRequerimento.getProtocolo();

			// Bloco responsavel por salvar no repositorio Alfresco os
			// Documentos
			// do requerimento
			for (Documento doc : this.documentos) {
				File file = new File(doc.getFile().getFileName());

				FileUtils.copyInputStreamToFile(doc.getFile().getInputstream(),
						file);

				uuid = alfrescoServico.anexarArquivo(bpmswebproperties
						.getProperty("bpms.fucapi.parent.uuid"), nomePasta,
						null, this.variaveisRequerimento.getDescricao(),
						this.usuario.getTicket(), file);

				doc.setUuid(uuid);

				/*
				 * Bloco responsavel por setar null para o atributo File de
				 * documento. Para recuperar o documento do Alfresco, deverah
				 * ser utilizado o atributo uuid
				 */
				doc.setFile(null);
			}

			this.variaveisRequerimento.setDocumentos(this.documentos);

		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String uploadNovoDesenho() {

		if (this.documento.getFile() != null) {
			FacesMessage msg = new FacesMessage("O documento "
					+ this.documento.getFile().getFileName()
					+ " foi inclu�do no formul�rio! ", this.documento.getFile()
					.getFileName() + " ");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.documentos.add(this.documento);
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"favor selecionar o arquivo.", "o arquivo "));
		}

		this.documento = new Documento();
		return "pages/processo/requerimento/lista_desenho.xhtml";
	}

	public String excluir(Documento documento) {
		this.documentos.remove(documento);
		FacesMessage msg = new FacesMessage("O documento "
				+ documento.getFile().getFileName()
				+ " foi removido do formulário! ", documento.getFile()
				.getFileName() + " ");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		return "pages/processo/lista_desenho.xhtml";
	}

	public void imprimir() {
		try {
			ExternalContext externalContext = FacesContext.getCurrentInstance()
					.getExternalContext();
			ServletContext context = (ServletContext) externalContext
					.getContext();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String arquivo = context
					.getRealPath("/WEB-INF/reports/tarefa.jasper");
			System.out.println(arquivo);

			FacesContext fc = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) fc
					.getExternalContext().getResponse();

			response.setContentType("application/pdf");
			response.addHeader("Content-disposition",
					"attachment; filename=\"pendencia.pdf\"");

			InputStream inputStream = new FileInputStream(new File(arquivo));

			JasperPrint impressao = JasperFillManager.fillReport(inputStream,
					null, new JRBeanCollectionDataSource(this.lista, false));

			JasperExportManager.exportReportToPdfStream(impressao,
					response.getOutputStream());

			facesContext.responseComplete();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public StreamedContent getFile() {
		return this.file;
	}

	public ActivitiServico getActivitiServico() {
		return activitiServico;
	}

	public void setActivitiServico(ActivitiServico activitiServico) {
		this.activitiServico = activitiServico;
	}

	public AlfrescoServico getAlfrescoServico() {
		return alfrescoServico;
	}

	public void setAlfrescoServico(AlfrescoServico alfrescoServico) {
		this.alfrescoServico = alfrescoServico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<TarefaInstancia> getLista() {
		return lista;
	}

	public void setLista(List<TarefaInstancia> lista) {
		this.lista = lista;
	}

	public TarefaInstancia getEntity() {
		return entity;
	}

	public void setEntity(TarefaInstancia entity) {
		this.entity = entity;
	}

	public GrupoAlfresco getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAlfresco grupo) {
		this.grupo = grupo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public void validarProprietario() {
		if (usuarioLogado.getUserName().equals(this.usuario.getUserName()))
			this.proprietario = true;
		else
			this.proprietario = false;
	}

	public boolean isProprietario() {
		return proprietario;
	}

	public void setProprietario(boolean proprietario) {
		this.proprietario = proprietario;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public VariaveisRequerimento getVariaveisRequerimento() {
		return variaveisRequerimento;
	}

	public void setVariaveisRequerimento(
			VariaveisRequerimento variaveisRequerimento) {
		this.variaveisRequerimento = variaveisRequerimento;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Properties getBpmswebproperties() {
		return bpmswebproperties;
	}

	public void setBpmswebproperties(Properties bpmswebproperties) {
		this.bpmswebproperties = bpmswebproperties;
	}

}