package br.com.ieadam.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ieadam_nucleo")
public class Nucleo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_nucleo")
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Situacao Situacao;
	
	@OneToOne
	private Membro coordenador;
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;
	
	@ManyToOne
	private Zona zona;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Situacao getSituacao() {
		return Situacao;
	}

	public void setSituacao(Situacao situacao) {
		Situacao = situacao;
	}

	public Membro getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Membro coordenador) {
		this.coordenador = coordenador;
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
}
