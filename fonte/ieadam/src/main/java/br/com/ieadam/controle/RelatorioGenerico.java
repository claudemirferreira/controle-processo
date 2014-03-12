package br.com.ieadam.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
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
import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.dto.FiltroRelatorioDTO;
import br.com.ieadam.servico.AreaServico;
import br.com.ieadam.servico.NucleoServico;
import br.com.ieadam.servico.ZonaServico;

@ManagedBean
@SessionScoped
public class RelatorioGenerico implements Serializable {

	private static final long serialVersionUID = 4085044268094923889L;

	private Parametro parametro;

	private FiltroRelatorioDTO filtroRelatorioDTO;

	@ManagedProperty(value = "#{relatorioUtil}")
	private RelatorioUtil relatorioUtil;

	@ManagedProperty(value = "#{zonaServicoImpl}")
	private ZonaServico zonaServico;

	@ManagedProperty(value = "#{areaServicoImpl}")
	private AreaServico areaServico;

	@ManagedProperty(value = "#{nucleoServicoImpl}")
	private NucleoServico nucleoServico;

	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;

	public void init() {
		this.filtroRelatorioDTO = new FiltroRelatorioDTO();

		this.filtroRelatorioDTO.setZona(new Zona());
		this.filtroRelatorioDTO.setNucleo(new Nucleo());
		this.filtroRelatorioDTO.setArea(new Area());

		this.filtroRelatorioDTO
				.setUsuarioLogado((Usuario) SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal());

		// chamada responsavel por preencher os combos de acordo com o nivel de
		// acesso do pastor
		this.filtroRelatorioDTO.preencherCombos(
				this.filtroRelatorioDTO.getUsuarioLogado(), zonaServico,
				nucleoServico, areaServico);

		this.parametro = new Parametro();

		this.parametro.setAno(DataUtil.pegarAnocorrente());
		this.parametro.setMes(DataUtil.pegarMescorrente());

		this.paginaCentralControlador
				.setPaginaCentral("paginas/relatorio/debitopastoral.xhtml");

	}

	public void atualizarNucleo() {
		this.filtroRelatorioDTO.setNucleos(this.nucleoServico
				.findByZona(this.filtroRelatorioDTO.getZona()));
		System.out.println(" nucleo = "
				+ this.filtroRelatorioDTO.getNucleos().size());

	}

	public void atualizarArea() {
		this.filtroRelatorioDTO.setAreas(this.areaServico
				.findByNucleo(this.filtroRelatorioDTO.getNucleo()));
		System.out.println(this.filtroRelatorioDTO.getAreas().size());

	}

	public void displayLocation() {
		FacesMessage msg = new FacesMessage("Selected", "City:");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void imprimir() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath("/WEB-INF/jasper/teste.jasper");

		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u = new Usuario();
		u.setLogin("login");
		usuarios.add(u);

		JRDataSource jrRS = new JRBeanCollectionDataSource(usuarios);

		Map<String, String> params = new HashMap<String, String>();
		params.put("dataInicio", this.parametro.getDataInicio());
		params.put("dataFim", this.parametro.getDataFim());

		relatorioUtil.gerarRelatorioWeb(params, arquivo);
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

	public PaginaCentralControlador getpaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setpaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	public ZonaServico getZonaServico() {
		return zonaServico;
	}

	public void setZonaServico(ZonaServico zonaServico) {
		this.zonaServico = zonaServico;
	}

	public AreaServico getAreaServico() {
		return areaServico;
	}

	public void setAreaServico(AreaServico areaServico) {
		this.areaServico = areaServico;
	}

	public NucleoServico getNucleoServico() {
		return nucleoServico;
	}

	public void setNucleoServico(NucleoServico nucleoServico) {
		this.nucleoServico = nucleoServico;
	}

}