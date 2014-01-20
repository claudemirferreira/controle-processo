package br.com.ieadam.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ieadam_zona")
public class Zona {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;
	
	private String nome;
	private String situacao;
	
	@OneToOne
	private Membro primeiroResponsavel;
	
	@OneToOne
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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
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
