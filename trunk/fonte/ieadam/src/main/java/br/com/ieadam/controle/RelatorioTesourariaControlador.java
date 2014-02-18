package br.com.ieadam.controle;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.componentes.Parametro;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dto.FiltroRelatorioDTO;

@ManagedBean
@SessionScoped
public class RelatorioTesourariaControlador {

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;
	
	private Parametro parametro;

	private FiltroRelatorioDTO filtroRelatorioDTO;

	private DriverManagerDataSource dataSource;

	List<Usuario> usuarios;

	@PostConstruct
	public void init() {
		this.filtroRelatorioDTO = new FiltroRelatorioDTO();
		this.filtroRelatorioDTO
				.setUsuarioLogado((Usuario) SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal());

		this.parametro = new Parametro();

		this.usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();

		usuario.setLogin("eeeeeee");
		usuarios.add(usuario);

		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"classpath*:META-INF/spring/applicationContext.xml");

		this.dataSource = (DriverManagerDataSource) beanFactory
				.getBean("datasource");

	}

	public void redirecionarModuloTesouraria() {
		paginaCentralControladorBean.setPaginaCentral("paginas/relatorio/tesouraria/pesquisa.xhtml");
	}
	
	public void relatorioSaldoCongregacional() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath("/WEB-INF/jasper/teste.jasper");

		JRDataSource jrRS = new JRBeanCollectionDataSource(this.usuarios);

		gerarRelatorioWeb(jrRS, null, arquivo);
	}

	public void relatorioProventoPastoral() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath("/WEB-INF/jasper/teste.jasper");

		JRDataSource jrRS = new JRBeanCollectionDataSource(this.usuarios);

		gerarRelatorioWeb(jrRS, null, arquivo);
	}

	public void relatorioDebitoFinanceiro() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath("/WEB-INF/jasper/teste.jasper");

		JRDataSource jrRS = new JRBeanCollectionDataSource(this.usuarios);

		gerarRelatorioWeb(jrRS, null, arquivo);
	}

	public void relatorioCentroCusto() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath("/WEB-INF/jasper/teste.jasper");

		JRDataSource jrRS = new JRBeanCollectionDataSource(this.usuarios);

		gerarRelatorioWeb(jrRS, null, arquivo);
	}

	public void relatorioNadaConsta() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath("/WEB-INF/jasper/teste.jasper");

		JRDataSource jrRS = new JRBeanCollectionDataSource(this.usuarios);

		gerarRelatorioWeb(jrRS, null, arquivo);
	}
	
	public void relatorioSaldoCongregacao() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath("/WEB-INF/jasper/teste.jasper");

		JRDataSource jrRS = new JRBeanCollectionDataSource(this.usuarios);

		gerarRelatorioWeb(jrRS, null, arquivo);
	}

	public void relatorioSaldoDepartamenal() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath("/WEB-INF/jasper/teste.jasper");

		JRDataSource jrRS = new JRBeanCollectionDataSource(this.usuarios);

		gerarRelatorioWeb(jrRS, null, arquivo);
	}

	
	private void gerarRelatorioWeb(JRDataSource jrRS, Map parametros,
			String arquivo) {
		ServletOutputStream servletOutputStream = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();

		try {
			servletOutputStream = response.getOutputStream();
			JasperRunManager.runReportToPdfStream(new FileInputStream(new File(
					arquivo)), response.getOutputStream(), parametros,
					this.dataSource.getConnection());

			response.setContentType("application/pdf");
			servletOutputStream.flush();
			servletOutputStream.close();
			context.renderResponse();
			context.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gerarRelatorio() {
		// TODO implements
		throw new RuntimeException("TODO implements...");
	}

	public FiltroRelatorioDTO getFiltroRelatorioDTO() {
		return filtroRelatorioDTO;
	}

	public void setFiltroRelatorioDTO(FiltroRelatorioDTO filtroRelatorioDTO) {
		this.filtroRelatorioDTO = filtroRelatorioDTO;
	}


	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}

	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
	}

	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

}