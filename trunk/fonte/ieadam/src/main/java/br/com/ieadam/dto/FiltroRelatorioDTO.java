package br.com.ieadam.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.ieadam.dominio.Area;
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

	public void preencherCombos(Usuario usuario, ZonaServico zonaServico,
			NucleoServico nucleoServico, AreaServico areaServico) {
		if (usuario.isZona()) {
			this.setZonas(new ArrayList<Zona>());

			this.setZonas(zonaServico.findByMembro(usuario.getMembro()));

			if (this.getZonas().size() == 1) {
				this.setNucleos(nucleoServico.findByZona(this.getZonas()
						.iterator().next()));
			}
		} else if (usuario.isNucleo()) {
			this.setNucleos(new ArrayList<Nucleo>());

			this.setNucleos(nucleoServico.findByMembro(usuario.getMembro()));

			if (this.getNucleos().size() > 0) {
				this.setZonas(new ArrayList<Zona>());
				this.getZonas().add(
						this.getNucleos().iterator().next().getZona());
			}

			this.setNucleos(nucleoServico.findByMembro(usuario.getMembro()));

			if (this.getNucleos().size() == 1) {
				this.setAreas(areaServico.findByNucleo(this.getNucleos()
						.iterator().next()));
			}
		} else if (usuario.isArea()) {
			this.setAreas(new ArrayList<Area>());
			this.setAreas(areaServico.findByMembro(usuario.getMembro()));

			if (this.getAreas().size() > 0) {
				this.setNucleos(new ArrayList<Nucleo>());
				this.getNucleos().add(
						this.getAreas().iterator().next().getNucleo());

				if (this.getNucleos().size() > 0) {
					this.setZonas(new ArrayList<Zona>());
					this.getZonas().add(
							this.getNucleos().iterator().next().getZona());
				}
			}
		}

	}
}
