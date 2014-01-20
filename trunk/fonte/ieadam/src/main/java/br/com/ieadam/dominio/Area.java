package br.com.ieadam.dominio;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ieadam_area")
public class Area {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_area")
	private int id;
	
	@OneToOne
	private Membro pastor;
	
	@ManyToOne
	private Nucleo nucleo;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

	@OneToMany(mappedBy="area")
	private Collection<Congregacao> congregacoes;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Membro getPastor() {
		return pastor;
	}

	public void setPastor(Membro pastor) {
		this.pastor = pastor;
	}

	public Nucleo getNucleo() {
		return nucleo;
	}

	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
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

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public Collection<Congregacao> getCongregacoes() {
		return congregacoes;
	}

	public void setCongregacoes(Collection<Congregacao> congregacoes) {
		this.congregacoes = congregacoes;
	}
}
