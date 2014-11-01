package br.com.ieadam.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "view_membro")
@Immutable
public class ViewMembro {

	@Id
	@Column
	private int idMembro;

	@Column
	private String membro;
	
	@Column
	private Integer idArea;

	@Column
	private String area;
	
	@Column
	private Integer idNucleo;

	@Column
	private String nucleo;

	@Column
	private Integer idZona;

	@Column
	private String zona;

	public int getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(int idMembro) {
		this.idMembro = idMembro;
	}

	public String getMembro() {
		return membro;
	}

	public void setMembro(String membro) {
		this.membro = membro;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(Integer idNucleo) {
		this.idNucleo = idNucleo;
	}

	public String getNucleo() {
		return nucleo;
	}

	public void setNucleo(String nucleo) {
		this.nucleo = nucleo;
	}

	public Integer getIdZona() {
		return idZona;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
}