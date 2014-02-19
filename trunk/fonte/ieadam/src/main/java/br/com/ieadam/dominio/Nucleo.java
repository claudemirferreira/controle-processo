package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ieadam_nucleo")
public class Nucleo extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1724329521623025890L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idNucleo;

	@Column(name = "situacao", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String situacao;

	@ManyToOne
	@JoinColumn(name = "id_coordenador", nullable = false)
	private Membro coordenador;

	@Column(length = 60, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

	@ManyToOne
	@JoinColumn(name = "id_zona", nullable = false)
	private Zona zona;

	@Override
	public Long getId() {
		return idNucleo;
	}

	public Long getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(Long idNucleo) {
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

	public Membro getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Membro coordenador) {
		this.coordenador = coordenador;
	}
}