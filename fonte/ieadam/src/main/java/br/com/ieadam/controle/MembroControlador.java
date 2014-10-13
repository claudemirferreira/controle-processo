package br.com.ieadam.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.servico.AreaServico;
import br.com.ieadam.servico.CongregacaoServico;
import br.com.ieadam.servico.MembroServico;
import br.com.ieadam.servico.NucleoServico;
import br.com.ieadam.servico.ZonaServico;

@ManagedBean
@SessionScoped
public class MembroControlador {

	private Membro entidade;

	private Membro pesquisa;

	private List<Membro> lista;

	private Congregacao congregacao = new Congregacao();

	private Zona zona = new Zona();

	private Area area = new Area();

	private Nucleo nucleo = new Nucleo();

	private List<Congregacao> congregacoes = new ArrayList<Congregacao>();

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

	@ManagedProperty(value = "#{congregacaoServicoImpl}")
	private CongregacaoServico congregacaoServico;

	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;

	private final String TELA_PESQUISA = "paginas/membro/pesquisa.xhtml";

	@PostConstruct
	public void init() {
		// this.lista = servico.listarTodos();

		this.congregacoes = congregacaoServico.listarTodos();

		this.zonas = zonaServico.listarTodos();

		this.areas = areaServico.listarTodos();

		this.nucleos = nucleoServico.listarTodos();

		this.paginaCentralControlador.setPaginaCentral(TELA_PESQUISA);

	}

	public MembroControlador() {
		this.entidade = new Membro();
		this.pesquisa = new Membro();
	}

	public void pesquisar() {
		// this.lista = this.servico.findByMembro(this.pesquisa);
	}

	public void excluir(Membro Membro) {
		this.servico.remover(Membro);
		this.lista = servico.listarTodos();
	}

	public String telaPesquisa() {
		this.pesquisa = new Membro();
		this.paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
		return "index.xhtml?faces-redirect=true";
	}

	public Membro getEntidade() {
		return entidade;
	}

	public void setEntidade(Membro entidade) {
		this.entidade = entidade;
	}

	public Membro getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Membro pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<Membro> getLista() {
		return lista;
	}

	public void setLista(List<Membro> lista) {
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
		this.setNucleos(new ArrayList<Nucleo>());
		this.setCongregacoes(new ArrayList<Congregacao>());
		this.setNucleo(new Nucleo());
		this.setArea(new Area());

		// lista todos os nucleos, areas e congregacões
		if (this.zona.getId() == -1) {
			this.setNucleos(this.nucleoServico.listarTodos());
			this.setAreas(this.areaServico.listarTodos());
			this.setCongregacoes(this.congregacaoServico.listarTodos());
		}
		// lista os nucleos, areas e congregacões de uma zona
		else {
			this.setNucleos(this.nucleoServico.findByZona(this.zona.getId()));
			this.setAreas(this.areaServico.listaAreaToZona(zona));
			this.setCongregacoes(this.congregacaoServico
					.listaCongregacaoToZona(zona));
		}
	}

	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarArea() {
		this.setAreas(new ArrayList<Area>());
		this.setAreas(this.areaServico.findByNucleo(this.nucleo.getId()));

	}

	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarCongregacao() {
		this.setCongregacoes(new ArrayList<Congregacao>());
		this.setCongregacoes(this.congregacaoServico.findByArea(this.area));

	}

	public PaginaCentralControlador getPaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setPaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public List<Congregacao> getCongregacoes() {
		return congregacoes;
	}

	public void setCongregacoes(List<Congregacao> congregacoes) {
		this.congregacoes = congregacoes;
	}

	public CongregacaoServico getCongregacaoServico() {
		return congregacaoServico;
	}

	public void setCongregacaoServico(CongregacaoServico congregacaoServico) {
		this.congregacaoServico = congregacaoServico;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Nucleo getNucleo() {
		return nucleo;
	}

	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}