package br.com.ieadam.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.componentes.DataUtil;
import br.com.ieadam.componentes.Parametro;
import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.dto.FiltroRelatorioDTO;
import br.com.ieadam.servico.AreaServico;
import br.com.ieadam.servico.MembroServico;
import br.com.ieadam.servico.NucleoServico;
import br.com.ieadam.servico.ZonaServico;

@ManagedBean
@SessionScoped
public class MembroControlador {

	private Membro entidade;

	private Membro pesquisa;

	private List<Membro> lista;

	private List<Perfil> perfis = new ArrayList<Perfil>();

	@ManagedProperty(value = "#{membroServicoImpl}")
	private MembroServico servico;
	
	@ManagedProperty(value = "#{zonaServicoImpl}")
	private ZonaServico zonaServico;

	@ManagedProperty(value = "#{nucleoServicoImpl}")
	private NucleoServico nucleoServico;

	@ManagedProperty(value = "#{areaServicoImpl}")
	private AreaServico areaServico;
	
	@ManagedProperty(value = "#{filtroRelatorioDTO}")
	private FiltroRelatorioDTO filtroRelatorioDTO;

	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;
	
	private final String TELA_PESQUISA = "paginas/membro/pesquisa.xhtml";
	
	@PostConstruct
	public void init() {
		this.lista = servico.listarTodos();
		
		this.filtroRelatorioDTO = new FiltroRelatorioDTO();

		this.filtroRelatorioDTO.setZona(new Zona());
		this.filtroRelatorioDTO.setNucleo(new Nucleo());
		this.filtroRelatorioDTO.setArea(new Area());

		this.filtroRelatorioDTO
				.setUsuarioLogado((Usuario) SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal());

		// chamada responsavel por preencher os combos de acordo com o nivel de
		// acesso do pastor
		this.preencherCombos(this.filtroRelatorioDTO.getUsuarioLogado());

		this.paginaCentralControlador.setPaginaCentral(TELA_PESQUISA);

	}
	
	public void preencherCombos(Usuario usuario) {

		this.filtroRelatorioDTO.setZonas(new ArrayList<Zona>());
		this.filtroRelatorioDTO.setNucleos(new ArrayList<Nucleo>());
		this.filtroRelatorioDTO.setAreas(new ArrayList<Area>());

		this.filtroRelatorioDTO.setZonas(this.zonaServico
				.listaZonaUsuario(usuario.getId()));

		if (this.filtroRelatorioDTO.getZonas().size() == 1) {
			this.filtroRelatorioDTO.setZona(this.filtroRelatorioDTO.getZonas().iterator().next());
			this.atualizarNucleo();
		}

		if (this.filtroRelatorioDTO.getNucleos().size() == 1) {
			this.filtroRelatorioDTO.setNucleo(this.filtroRelatorioDTO.getNucleos().iterator().next());
			this.atualizarArea();
		}
	}
	
	public void atualizarNucleo() {
		
		boolean zonaAssociada = false;

		this.filtroRelatorioDTO.setNucleos(new ArrayList<Nucleo>());
		this.filtroRelatorioDTO.setNucleo(new Nucleo());
		this.filtroRelatorioDTO.setAreas(new ArrayList<Area>());
		this.filtroRelatorioDTO.setArea(new Area());

		/*
		 * Verifica se a zona escolhida no combo esta associada ao usuario. SE
		 * estiver, devera listar todos os Nucleos desta zona e nao apenas o
		 * Nucleo associado.
		 */
		zonaAssociada = this.zonaServico.isUsuarioDeZona(
				this.filtroRelatorioDTO.getUsuarioLogado().getId(),
				this.filtroRelatorioDTO.getZona().getId());
		
		this.filtroRelatorioDTO.setAreas(new ArrayList<Area>()); 

		/*
		 * SE a ZONA nao estiver associada ao usuario, deverah ser pesquisado os
		 * NUCLEOS que o usuario faz parte DESTA regiao
		 */
		if (!zonaAssociada) {
			this.filtroRelatorioDTO.setNucleos(this.nucleoServico
					.listaNucleoToUsuarioAndZona(
							this.filtroRelatorioDTO.getUsuarioLogado(),
							this.filtroRelatorioDTO.getZona()));
		}

		/*
		 * SE a lista de nucleos estiver vazia, significa que o Usuario eh de
		 * REGIAO
		 */
		if (this.filtroRelatorioDTO.getNucleos().size() == 0) {
			this.filtroRelatorioDTO.setNucleos(this.nucleoServico
					.findByZona(this.filtroRelatorioDTO.getZona().getId()));
		}

		/*
		 * SE a lista de NUCLEO estiver com tamanho 1, deverah ser setado o
		 * NUCLEO da lista no objeto NUCLEO e deverah atualizar o combo de AREA
		 */
		else if (this.filtroRelatorioDTO.getNucleos().size() == 1) {
			this.filtroRelatorioDTO.setNucleo(this.filtroRelatorioDTO
					.getNucleos().iterator().next());
			this.atualizarArea();
		} 

	}

	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarArea() {

		this.filtroRelatorioDTO.setAreas(new ArrayList<Area>());
		this.filtroRelatorioDTO.setArea(new Area());
		
		boolean nucleoAssociado = false;

		if (this.filtroRelatorioDTO.getNucleo().getId() != 0) {
			/*
			 * Verifica se o nucleo escolhido no combo esta associado ao usuario. SE
			 * estiver, devera listar todas as Areas deste nucleo e nao apenas a
			 * Area associada.
			 */
			nucleoAssociado = this.nucleoServico.isUsuarioDeNucleo(
					this.filtroRelatorioDTO.getUsuarioLogado().getId(),
					this.filtroRelatorioDTO.getNucleo().getId());
	
			/*
			 * SE o NUCLEO nao estiver associada ao usuario, deverah ser pesquisada
			 * as AREAS que o usuario faz parte DESTE nucleo
			 */
			if (!nucleoAssociado) {
	
				this.filtroRelatorioDTO.setAreas(this.areaServico
						.listaAreaToUsuarioAndNucleo(
								this.filtroRelatorioDTO.getUsuarioLogado(),
								this.filtroRelatorioDTO.getNucleo()));
				/*
				 * SE a lista de AREA estiver com tamanho 1, deverah ser setado a
				 * AREA da lista no objeto AREA
				 */
				if (this.filtroRelatorioDTO.getAreas().size() == 1)
					this.filtroRelatorioDTO.setArea(this.filtroRelatorioDTO
							.getAreas().iterator().next());
			}
	
			/*
			 * SE a lista de areas estiver vazia, significa que o Usuario eh de
			 * NUCLEO
			 */
			if (this.filtroRelatorioDTO.getAreas().size() == 0) {
				this.filtroRelatorioDTO.setAreas(this.areaServico
						.findByNucleo(this.filtroRelatorioDTO.getNucleo().getId()));
			}
		}
	}

	public MembroControlador() {
		this.entidade = new Membro();
		this.pesquisa = new Membro();
	}

	public void pesquisar() {
//		this.lista = this.servico.findByMembro(this.pesquisa);
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

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public PaginaCentralControlador getPaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setPaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	public FiltroRelatorioDTO getFiltroRelatorioDTO() {
		return filtroRelatorioDTO;
	}

	public void setFiltroRelatorioDTO(FiltroRelatorioDTO filtroRelatorioDTO) {
		this.filtroRelatorioDTO = filtroRelatorioDTO;
	}
}