package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "ieadam_nucleo")
public class Nucleo extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1724329521623025890L;

	@Id
	private int idNucleo;

	@Column(name = "situacao", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String situacao;

	@Column
	private int idCoordenador;
	
	@Column(length = 60, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

	@Transient
	private boolean usuarioNucleo;
	
	@ManyToOne
	@JoinColumn(name = "id_zona")
	private Zona zona;
	
//	@Column
//	private int idZona;

	@Override
	public int getId() {
		return idNucleo;
	}

	public int getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(int idNucleo) {
		this.idNucleo = idNucleo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
	
	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
//	public int getIdZona() {
//		return idZona;
//	}
//
//	public void setIdZona(int idZona) {
//		this.idZona = idZona;
//	}

	public int getIdCoordenador() {
		return idCoordenador;
	}

	public void setIdCoordenador(int idCoordenador) {
		this.idCoordenador = idCoordenador;
	}

	public boolean isUsuarioNucleo() {
		return usuarioNucleo;
	}

	public void setUsuarioNucleo(boolean usuarioNucleo) {
		this.usuarioNucleo = usuarioNucleo;
	}
	
}