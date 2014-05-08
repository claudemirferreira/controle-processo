package br.com.ieadam.controle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.com.ieadam.componentes.Util;
import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Rotina;
import br.com.ieadam.dominio.Sistema;
import br.com.ieadam.servico.RotinaServico;

@ManagedBean
@SessionScoped
public class RotinaControlador implements Serializable {

	private static final long serialVersionUID = -6832271293709421841L;
	
	private static final int SISTEMA_IEADAM = 2;

	private Rotina entidade;

	private Rotina pesquisa;

	private Perfil perfil;
	
	private Sistema sistema = new Sistema(SISTEMA_IEADAM);

	private List<Rotina> lista;

	private UploadedFile file;

	private StreamedContent imagem;

	private int colunas;

	private final String TELA_CADASTRO = "paginas/rotina/cadastro.xhtml";
	private final String TELA_PESQUISA = "paginas/rotina/pesquisa.xhtml";

	private String TELA_LISTA_ROTINAS = "paginas/rotina/lista.xhtml";
	private final String TELA_ROTINA_PERFIL = "paginas/rotina/rotinaperfil.xhtml";

	@ManagedProperty(value = "#{rotinaServicoImpl}")
	private RotinaServico servico;

	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;

	public void handleFileUpload(FileUploadEvent event) {
		try {
			File targetFolder = new File("C:\\Androide");
			InputStream inputStream = event.getFile().getInputstream();
			this.imagem = null;
			this.imagem = new DefaultStreamedContent(event.getFile()
					.getInputstream(), "image/png");
			OutputStream out = new FileOutputStream(new File(targetFolder,
					event.getFile().getFileName()));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			entidade.setLogomarca(bytes);
			// entidade.setStreamedContent(this.imagem);
			inputStream.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		
		this.lista = servico.listarTodos();
		telaPesquisa();
	}

	public RotinaControlador() {
		this.entidade = new Rotina();
		this.pesquisa = new Rotina();
		this.perfil = new Perfil();
	}

	public void pesquisar() {
		this.lista = servico.findByNomeLike(this.pesquisa.getNome());
	}

	public void detalhe(Rotina rotina) {
		this.imagem = Util.converterBytesToStreamedContent(rotina
				.getLogomarca());
		this.entidade = rotina;
		this.paginaCentralControlador.setPaginaCentral(this.TELA_CADASTRO);
	}

	public void salvar() {
		this.servico.salvar(this.entidade);
		this.lista = servico.listarTodos();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Operação realizada com sucesso!", null));

		this.paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void excluir(Rotina rotina) {
		servico.remover(rotina);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Operação realizada com sucesso!", null));

		this.lista = servico.listarTodos();
	}

	public void novo() {
		this.entidade = new Rotina();
		this.entidade.setSistema(sistema);
		this.paginaCentralControlador.setPaginaCentral(this.TELA_CADASTRO);
	}

	public void telaRotinas(Perfil perfil) {
		this.perfil = perfil;
		telaRotinas();
	}

	public void telaRotinas() {
		this.lista = servico.listaRotinasPorPerfil(this.perfil.getId());
		this.colunas = Util.definirTamanhoColuna(lista.size());
		this.paginaCentralControlador.setPaginaCentral(this.TELA_LISTA_ROTINAS);

	}

	public void retornar() {
		this.paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void telaRelatorio(Rotina rotina) {
		this.paginaCentralControlador.setPaginaCentral(rotina.getAcao());
	}

	public Rotina getEntidade() {
		return entidade;
	}

	public void setEntidade(Rotina entidade) {
		this.entidade = entidade;
	}

	public Rotina getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Rotina pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Rotina> getLista() {
		return lista;
	}

	public void setLista(List<Rotina> lista) {
		this.lista = lista;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public PaginaCentralControlador getpaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setpaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	public RotinaServico getServico() {
		return servico;
	}

	public void setServico(RotinaServico servico) {
		this.servico = servico;
	}

	public void telaPesquisa() {
		this.paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void telaRotinas(Rotina rotina) {

		this.paginaCentralControlador.setPaginaCentral(rotina.getAcao());
	}

	public StreamedContent getImagem() {
		imagem = Util.converterBytesToStreamedContent(entidade.getLogomarca());
		return imagem;
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}

}