package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the _perfil_rotina database table.
 * 
 */
@Entity
@Table(name = "saa_perfil_rotina")
public class PerfilRotina implements Serializable {

	private static final long serialVersionUID = -7000133381800494391L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@ManyToOne
	@JoinColumn(name = "rotina_id")
	private Rotina rotina;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;

	public PerfilRotina() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Rotina getRotina() {
		return this.rotina;
	}

	public void setRotina(Rotina rotina) {
		this.rotina = rotina;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}