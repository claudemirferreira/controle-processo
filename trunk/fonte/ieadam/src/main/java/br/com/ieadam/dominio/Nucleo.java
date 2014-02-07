package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ieadam.dominio.enumerated.Situacao;

@Entity
@Table(name = "ieadam_nucleo")
public class Nucleo implements Serializable{

	private static final long serialVersionUID = 1724329521623025890L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "situacao", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String situacao;

	@OneToOne
	@JoinColumn(name="id", referencedColumnName="coordenador_id")
	private Membro coordenador;

	@Column(length = 60, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

	@ManyToOne
	@JoinColumn(name="zona_id", referencedColumnName="id", nullable = false)
	private Zona zona;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
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