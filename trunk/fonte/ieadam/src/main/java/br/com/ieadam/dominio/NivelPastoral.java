package br.com.ieadam.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ieadam_nivel_pastoral")
public class NivelPastoral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;

	@Column
	private Boolean zona_id;

	@Column
	private Boolean nucleo_id;

	@Column
	private Boolean area_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getZona_id() {
		return zona_id;
	}

	public void setZona_id(Boolean zona_id) {
		this.zona_id = zona_id;
	}

	public Boolean getNucleo_id() {
		return nucleo_id;
	}

	public void setNucleo_id(Boolean nucleo_id) {
		this.nucleo_id = nucleo_id;
	}

	public Boolean getArea_id() {
		return area_id;
	}

	public void setArea_id(Boolean area_id) {
		this.area_id = area_id;
	}
}