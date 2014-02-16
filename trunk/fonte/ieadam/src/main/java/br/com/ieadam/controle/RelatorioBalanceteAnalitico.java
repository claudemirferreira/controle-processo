package br.com.ieadam.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.componentes.DataUtil;
import br.com.ieadam.componentes.Parametro;
import br.com.ieadam.componentes.RelatorioUtil;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dto.FiltroRelatorioDTO;

@ManagedBean
@SessionScoped
public class RelatorioBalanceteAnalitico implements Serializable {

	private static final long serialVersionUID = 4085044268094923889L;

	private Parametro parametro;

	private FiltroRelatorioDTO filtroRelatorioDTO;

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	@ManagedProperty(value = "#{relatorioUtil}")
	private RelatorioUtil relatorioUtil;

	List<Usuario> usuarios;

	public RelatorioBalanceteAnalitico() {
		this.parametro = new Parametro();

	}

	public void init() {
		this.filtroRelatorioDTO = new FiltroRelatorioDTO();
		this.filtroRelatorioDTO
				.setUsuarioLogado((Usuario) SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal());

		this.parametro.setAno(DataUtil.pegarAnocorrente());
		this.parametro.setMes(DataUtil.pegarMescorrente());

		this.usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();

		usuario.setLogin("eeeeeee");
		usuarios.add(usuario);

		this.paginaCentralControladorBean
				.setPaginaCentral("paginas/relatorio/balanceteanalitico.xhtml");

	}

	public void imprimir() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath("/WEB-INF/jasper/teste.jasper");

		JRDataSource jrRS = new JRBeanCollectionDataSource(this.usuarios);

		relatorioUtil.gerarRelatorioWeb(jrRS, null, arquivo);

	}

	public FiltroRelatorioDTO getFiltroRelatorioDTO() {
		return filtroRelatorioDTO;
	}

	public void setFiltroRelatorioDTO(FiltroRelatorioDTO filtroRelatorioDTO) {
		this.filtroRelatorioDTO = filtroRelatorioDTO;
	}

	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public RelatorioUtil getRelatorioUtil() {
		return relatorioUtil;
	}

	public void setRelatorioUtil(RelatorioUtil relatorioUtil) {
		this.relatorioUtil = relatorioUtil;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}

	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
	}

}