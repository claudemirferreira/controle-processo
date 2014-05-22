package br.com.ieadam.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.springframework.stereotype.Component;

import br.com.ieadam.componentes.DataUtil;
import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Mes;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.servico.AreaServico;
import br.com.ieadam.servico.NucleoServico;
import br.com.ieadam.servico.UsuarioAreaServico;
import br.com.ieadam.servico.UsuarioNucleoServico;
import br.com.ieadam.servico.UsuarioZonaServico;
import br.com.ieadam.servico.ZonaServico;

@Component
public class FiltroRelatorioDTO implements Serializable {

	private static final long serialVersionUID = 3229078578713401437L;

	private String tipoRelatorio;

	private String dataInicial;

	private String dataFinal;

	private Usuario usuarioLogado;

	private Usuario membro;

	private Zona zona;

	private Nucleo nucleo;

	private Area area;

	private List<Zona> zonas;

	private List<Area> areas;

	private List<Nucleo> nucleos;

	private List<Integer> anos;

	private int anoInicio;

	private int anoFim;

	private Mes mesInicio = Mes.JANEIRO;

	private Mes mesFim = Mes.JANEIRO;

	private Mes[] meses;
	
	@ManagedProperty(value = "#{zonaServicoImpl}")
	private ZonaServico zonaServico;
	
	@ManagedProperty(value = "#{nucleoServicoImpl}")
	private NucleoServico nucleoServico;
	
	@ManagedProperty(value = "#{areaServicoImpl}")
	private AreaServico areaServico;
	
	@ManagedProperty(value = "#{usuarioZonaServicoImpl}")
	private UsuarioZonaServico usuarioZonaServico;
	
	@ManagedProperty(value = "#{usuarioNucleoServicoImpl}")
	private UsuarioNucleoServico usuarioNucleoServico;
	
	@ManagedProperty(value = "#{usuarioAreaServicoImpl}")
	private UsuarioAreaServico usuarioAreaServico;

	public FiltroRelatorioDTO() {
		this.anos = DataUtil.pegarAnos();
		this.anoInicio = DataUtil.pegarAnocorrente();
		this.anoFim = DataUtil.pegarAnocorrente();
	}

	public String getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(String tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Usuario getMembro() {
		return membro;
	}

	public void setMembro(Usuario membro) {
		this.membro = membro;
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
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

	public List<Integer> getAnos() {
		return anos;
	}

	public void setAnos(List<Integer> anos) {
		this.anos = anos;
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}

	public int getAnoFim() {
		return anoFim;
	}

	public void setAnoFim(int anoFim) {
		this.anoFim = anoFim;
	}

	public Mes[] getMeses() {
		return Mes.values();
	}

	public Mes getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(Mes mesInicio) {
		this.mesInicio = mesInicio;
	}

	public Mes getMesFim() {
		return mesFim;
	}

	public void setMesFim(Mes mesFim) {
		this.mesFim = mesFim;
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

	
	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarNucleo() {
		boolean zonaAssociada = false;
		
		this.setNucleos(new ArrayList<Nucleo>());
		
		/*
		 *  Verifica se a zona escolhida no combo esta associada ao usuario.
		 *  SE estiver, devera listar todos os Nucleos desta zona e nao apenas o Nucleo associado.
		 */
		zonaAssociada = this.zonaServico.isUsuarioDeZona(
				this.getUsuarioLogado().getId(), this.getZona().getId());
		
		/*
		 *  SE a ZONA nao estiver associada ao usuario,
		 *  deverah ser pesquisado os NUCLEOS que o usuario faz parte DESTA regiao 
		 */
		if (!zonaAssociada) {
			this.setNucleos(this.nucleoServico.listaNucleoToUsuarioAndZona(
					this.getUsuarioLogado(), this.getZona()));
		}
		
		/*
		 * SE a lista de nucleos estiver vazia, significa que o Usuario eh de REGIAO
		 */
		if (this.getNucleos().size() == 0) {
			this.setNucleos(this.nucleoServico.findByZona(this.getZona().getId()));			
		}
		
		/*
		 *  SE a lista de NUCLEO estiver com tamanho 1,
		 *  deverah ser setado o NUCLEO da lista no objeto NUCLEO e
		 *  deverah atualizar o combo de AREA
		 */
		if (this.getNucleos().size() == 1) {
			this.setNucleo(this.getNucleos().iterator().next());
			this.atualizarArea();
		}
		
		System.out.println(" nucleo = " + this.getNucleos().size());
	}

	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarArea() {
		
		this.setAreas(new ArrayList<Area>());
		
		boolean nucleoAssociado = false;
		
		/*
		 *  Verifica se o nucleo escolhido no combo esta associado ao usuario.
		 *  SE estiver, devera listar todas as Areas deste nucleo e nao apenas a Area associada.
		 */
		nucleoAssociado = this.nucleoServico.isUsuarioDeNucleo(
				this.getUsuarioLogado().getId(), this.getNucleo().getId());
		
		/*
		 *  SE o NUCLEO nao estiver associada ao usuario,
		 *  deverah ser pesquisada as AREAS que o usuario faz parte DESTE nucleo 
		 */
		if (!nucleoAssociado) {
			
			this.setAreas(this.areaServico.listaAreaToUsuarioAndNucleo(
					this.getUsuarioLogado(), this.getNucleo()));
		}
		
		/*
		 * SE a lista de areas estiver vazia, significa que o Usuario eh de NUCLEO
		 */
		if (this.getAreas().size() == 0) {
			this.setAreas(this.areaServico.findByNucleo(this.getNucleo().getId()));			
		}
	}
}
