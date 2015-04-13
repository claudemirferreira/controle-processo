package br.com.ieadam.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import com.lowagie.text.DocumentException;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.LogApp;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.ViewMembro;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.servico.AreaServico;
import br.com.ieadam.servico.LogAppServico;
import br.com.ieadam.servico.MembroServico;
import br.com.ieadam.servico.NucleoServico;
import br.com.ieadam.servico.ZonaServico;

@ManagedBean
@SessionScoped
public class MembroControlador {

	private ViewMembro pesquisa;

	private List<ViewMembro> lista;

	private List<Zona> zonas = new ArrayList<Zona>();

	private List<Area> areas = new ArrayList<Area>();

	private List<Nucleo> nucleos = new ArrayList<Nucleo>();

	@ManagedProperty(value = "#{membroServicoImpl}")
	private MembroServico servico;

	@ManagedProperty(value = "#{zonaServicoImpl}")
	private ZonaServico zonaServico;

	@ManagedProperty(value = "#{nucleoServicoImpl}")
	private NucleoServico nucleoServico;

	@ManagedProperty(value = "#{areaServicoImpl}")
	private AreaServico areaServico;
	
	@ManagedProperty(value = "#{logAppServicoImpl}")
	private LogAppServico logAppServico;

	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;

	private final String TELA_PESQUISA = "paginas/relatorio/membro.xhtml";
	
	private final String TELA_DETALHE = "paginas/membro/detalhe-membro.xhtml";
	
	private ViewMembro viewMembro;
	
	@ManagedProperty(value = "#{relatorioMembro}")
	private RelatorioMembro relatorioMembro;

	@PostConstruct
	public void init() {
		
		this.pesquisa = new ViewMembro();
		
		this.zonas = zonaServico.listarTodos();
		
		this.areas = new ArrayList<Area>();

		this.nucleos = new ArrayList<Nucleo>();
		
		this.paginaCentralControlador.setPaginaCentral(TELA_PESQUISA);
		
		this.lista = new ArrayList<ViewMembro>();
		
		this.relatorioMembro.setVisualizar(false);
	}

	public MembroControlador() {
		this.pesquisa = new ViewMembro();
	}

	private void salvarLogApp() {
		LogApp logApp = new LogApp();
		logApp.setDataHoraAcao(new Date());
		logApp.setAcaoUsuario("REALIZACAO DE PESQUISA DE MEMBRO");
		logApp.setUsuario((Usuario) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal());
		
		this.logAppServico.salvar(logApp);
	}
	
	public void pesquisar() {
		
		this.salvarLogApp();
		
		if (this.pesquisa.getIdArea() != null
				&& this.pesquisa.getIdArea() != -1) {
			this.pesquisa.setIdZona(null);
			this.pesquisa.setIdNucleo(null);
			
		} else if (this.pesquisa.getIdNucleo() != null 
				&& this.pesquisa.getIdNucleo() != -1) {
			this.pesquisa.setIdZona(null);
			this.pesquisa.setIdArea(null);
		}
		
		this.lista = this.servico.listarMembrosByFiltros(this.pesquisa);
	}

	public String telaPesquisa() {
		this.pesquisa = new ViewMembro();
		this.paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
		return "index.xhtml?faces-redirect=true";
	}
	
	public String detalhar(ViewMembro membro) {
		this.viewMembro = membro;
		this.paginaCentralControlador.setPaginaCentral(this.TELA_DETALHE);
		return "index.xhtml?faces-redirect=true";
	}
	
	public String voltarListaMembro() {
		this.paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
		return "index.xhtml?faces-redirect=true";
	}
	
	public void relatorio() {
		try {
			this.relatorioMembro.processarPDF(this.viewMembro.getIdMembro());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public ViewMembro getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(ViewMembro pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<ViewMembro> getLista() {
		return lista;
	}

	public void setLista(List<ViewMembro> lista) {
		this.lista = lista;
	}

	public MembroServico getServico() {
		return servico;
	}

	public void setServico(MembroServico servico) {
		this.servico = servico;
	}

	public ZonaServico getZonaServico() {
		return zonaServico;
	}

	public void setZonaServico(ZonaServico zonaServico) {
		this.zonaServico = zonaServico;
	}

	public NucleoServico getNucleoServico() {
		return nucleoServico;
	}

	public void setNucleoServico(NucleoServico nucleoServico) {
		this.nucleoServico = nucleoServico;
	}

	public AreaServico getAreaServico() {
		return areaServico;
	}

	public void setAreaServico(AreaServico areaServico) {
		this.areaServico = areaServico;
	}

	public PaginaCentralControlador getpaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setpaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarNucleo() {
		this.relatorioMembro.setVisualizar(false);
		
		this.setNucleos(new ArrayList<Nucleo>());
		this.setAreas(new ArrayList<Area>());
		this.pesquisa.setIdNucleo(null);
		
		if (this.pesquisa.getIdZona() != -1) {
			this.setNucleos(this.nucleoServico.findByZona(this.pesquisa.getIdZona()));
		}
	}

	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarArea() {
		this.relatorioMembro.setVisualizar(false);
		this.setAreas(new ArrayList<Area>());
		this.setAreas(this.areaServico.findByNucleo(this.pesquisa.getIdNucleo()));
	}

	public PaginaCentralControlador getPaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setPaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	public List<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<Nucleo> getNucleos() {
		return nucleos;
	}

	public void setNucleos(List<Nucleo> nucleos) {
		this.nucleos = nucleos;
	}

	public ViewMembro getViewMembro() {
		return viewMembro;
	}

	public void setViewMembro(ViewMembro viewMembro) {
		this.viewMembro = viewMembro;
	}

	public RelatorioMembro getRelatorioMembro() {
		return relatorioMembro;
	}

	public void setRelatorioMembro(RelatorioMembro relatorioMembro) {
		this.relatorioMembro = relatorioMembro;
	}
	
	public LogAppServico getLogAppServico() {
		return logAppServico;
	}

	public void setLogAppServico(LogAppServico logAppServico) {
		this.logAppServico = logAppServico;
	}
}