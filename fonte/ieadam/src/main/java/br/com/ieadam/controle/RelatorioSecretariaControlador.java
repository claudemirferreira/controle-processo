package br.com.ieadam.controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dto.FiltroRelatorioDTO;

@ManagedBean
@SessionScoped
public class RelatorioSecretariaControlador {

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;
	
	private FiltroRelatorioDTO filtroRelatorioDTO;

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	@PostConstruct
	public void init() {
		this.filtroRelatorioDTO = new FiltroRelatorioDTO();
		this.filtroRelatorioDTO
				.setUsuarioLogado((Usuario) SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal());

		Usuario usuario = new Usuario();
		usuario.setLogin("teste");

		this.usuarios.add(usuario);
	}

	public void redirecionarModuloSecretaria() {
		paginaCentralControladorBean.setPaginaCentral("paginas/relatorio/secretaria/pesquisa.xhtml");
	}
	
	public void imprimir() {
		try {

			ExternalContext externalContext = FacesContext.getCurrentInstance()
					.getExternalContext();
			ServletContext context = (ServletContext) externalContext
					.getContext();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String arquivo = context
					.getRealPath("/WEB-INF/jasper/teste.jasper");
			System.out.println(arquivo);

			FacesContext fc = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) fc
					.getExternalContext().getResponse();

			response.setContentType("application/pdf");
			response.addHeader("Content-disposition",
					"attachment; filename=\"teste.pdf\"");

			InputStream inputStream = new FileInputStream(new File(arquivo));

			JasperPrint impressao = JasperFillManager.fillReport(inputStream,
					null, new JRBeanCollectionDataSource(this.usuarios, false));

			JasperExportManager.exportReportToPdfStream(impressao,
					response.getOutputStream());

			facesContext.responseComplete();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void gerarRelatorio() {
//		this.relatorioSecretariaServico
//				.gerarRelatorioSecretaria(this.filtroRelatorioDTO);
		// TODO implements
		throw new RuntimeException("TODO implements...");
	}

	public String relatorioSecretaria() {
		return "/pages/relatorio/secretaria/pesquisa.jsf";
	}

	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}

	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
	}

	public FiltroRelatorioDTO getFiltroRelatorioDTO() {
		return filtroRelatorioDTO;
	}

	public void setFiltroRelatorioDTO(FiltroRelatorioDTO filtroRelatorioDTO) {
		this.filtroRelatorioDTO = filtroRelatorioDTO;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
