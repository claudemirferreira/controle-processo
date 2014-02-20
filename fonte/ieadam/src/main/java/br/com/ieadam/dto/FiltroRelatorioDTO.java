package br.com.ieadam.dto;

import java.io.Serializable;
import java.util.List;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;

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
}
