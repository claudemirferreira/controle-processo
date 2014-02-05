package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ieadam.dominio.enumerated.Situacao;

@Entity
@Table(name = "ieadam_area")
public class Area implements Serializable{

	private static final long serialVersionUID = -6455533571538685292L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@OneToOne
	@JoinColumn(name = "pastor_id", referencedColumnName = "id", unique = true)
	private Membro pastor;

	@ManyToOne
	@JoinColumn(name = "nucleo_id", referencedColumnName = "id", unique = true)
	private Nucleo nucleo;

	@Column(length = 60, nullable = false)
	private String nome;

	@Enumerated
	@Column(length=1)
	private Situacao situacao;

	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

	@OneToMany
	@JoinColumn(name="area_id", referencedColumnName = "id")
	private Set<Congregacao> congregacoes;

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

	public Set<Congregacao> getCongregacoes() {
		return congregacoes;
	}

	public void setCongregacoes(Set<Congregacao> congregacoes) {
		this.congregacoes = congregacoes;
	}
}