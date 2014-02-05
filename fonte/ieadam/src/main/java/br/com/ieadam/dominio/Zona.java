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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ieadam.dominio.enumerated.Situacao;

@Entity
@Table(name="ieadam_zona")
public class Zona implements Serializable{

	private static final long serialVersionUID = -6148396536721220451L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;
	
	@Column(nullable = false, length=60)
	private String nome;
	
	@Enumerated
	@Column(name = "situacao", nullable = false, length = 1)
	private Situacao situacao;
	
	@OneToOne
	@JoinColumn(name="primeiro_resp_id", referencedColumnName="id")
	private Membro primeiroResponsavel;
	
	@OneToOne
	@JoinColumn(name="segundo_resp_id", referencedColumnName="id")
	private Membro segundoResponsavel;
	
	private int cd_ZonaArgo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Membro getPrimeiroResponsavel() {
		return primeiroResponsavel;
	}

	public void setPrimeiroResponsavel(Membro primeiroResponsavel) {
		this.primeiroResponsavel = primeiroResponsavel;
	}

	public Membro getSegundoResponsavel() {
		return segundoResponsavel;
	}

	public void setSegundoResponsavel(Membro segundoResponsavel) {
		this.segundoResponsavel = segundoResponsavel;
	}

	public int getCd_ZonaArgo() {
		return cd_ZonaArgo;
	}

	public void setCd_ZonaArgo(int cd_ZonaArgo) {
		this.cd_ZonaArgo = cd_ZonaArgo;
	}
}