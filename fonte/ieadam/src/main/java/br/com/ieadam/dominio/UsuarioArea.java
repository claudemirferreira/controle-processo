package br.com.ieadam.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ieadam_usuario_area")
public class UsuarioArea extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -6455533571538685292L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUsuarioArea;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_area")
	private Area area;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getIdUsuarioArea() {
		return idUsuarioArea;
	}

	public void setIdUsuarioArea(int idUsuarioArea) {
		this.idUsuarioArea = idUsuarioArea;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}