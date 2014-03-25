package br.com.ieadam.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.ieadam.componentes.DataUtil;
import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Mes;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.servico.AreaServico;
import br.com.ieadam.servico.NucleoServico;
import br.com.ieadam.servico.ZonaServico;

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

	public void preencherCombos(Usuario usuario, ZonaServico zonaServico,
			NucleoServico nucleoServico, AreaServico areaServico) {
		
		this.setZonas(new ArrayList<Zona>());
		this.setNucleos(new ArrayList<Nucleo>());
		this.setAreas(new ArrayList<Area>());
		
		if (usuario.isZona()) {
			this.setZonas(zonaServico.findByMembro(usuario.getIdMembro()));

			if (this.getZonas().size() == 1) {
				this.setZona(this.getZonas().iterator().next());
				this.setNucleos(nucleoServico.findByZona(this.getZonas()
						.iterator().next().getIdZona()));
				
				// TODO Verificar com Dryen se uma Zona poderah ter apenas um Nucleo e se um Nucleo poderah ter apenas uma area
//				if (this.getNucleos().size() == 1) {
//					this.setNucleo(this.getNucleos().iterator().next());
//					this.setAreas(areaServico.findByNucleo(this.getNucleos()
//						.iterator().next().getIdNucleo()));
//				}
			}
		} else if (usuario.isNucleo()) {
			this.setNucleos(nucleoServico.findByMembro(usuario.getIdMembro()));
			
			this.getZonas().add(zonaServico.findOne(this.getNucleos().iterator().next().getIdZona()));
			this.setZona(this.getZonas().iterator().next());
			
			if (this.getNucleos().size() == 1) {
				this.setNucleo(this.getNucleos().iterator().next());
				this.setAreas(areaServico.findByNucleo(this.getNucleos()
						.iterator().next().getIdNucleo()));
			}
			
		} else if (usuario.isArea()) {
			
			this.setAreas(areaServico.findByMembro(usuario.getIdMembro()));

			if (this.getAreas().size() > 0) {
				
				if (this.getAreas().size() == 1) {
					this.setArea(this.getAreas().iterator().next());
				}
				
				this.getNucleos().add(
						nucleoServico.findOne(this.getAreas().iterator().next().getIdNucleo()));
				this.setNucleo(this.getNucleos().iterator().next());

				if (this.getNucleos().size() > 0) {
					this.getZonas().add(
							zonaServico.findOne(this.getNucleos().iterator().next().getIdZona()));
					this.setZona(this.getZonas().iterator().next());
				}
			}
		}
	}
}
