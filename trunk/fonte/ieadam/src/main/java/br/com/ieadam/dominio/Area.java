package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ieadam_area")
public class Area extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -6455533571538685292L;

	@Id
	private int idArea;

//	@ManyToOne
//	@JoinColumn(name = "id_pastor")
//	private Membro membro;
	
	@Column
	private int idPastor;

//	@ManyToOne
//	@JoinColumn(name = "id_nucleo")
//	private Nucleo nucleo;
	
	@Column
	private int idNucleo;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(name = "situacao", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String situacao;

	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

//	@OneToMany
//	@JoinColumn(name = "id_area")
//	private List<Congregacao> congregacoes;

	
	@Override
	public int getId() {
		return idArea;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getIdPastor() {
		return idPastor;
	}

	public void setIdPastor(int idPastor) {
		this.idPastor = idPastor;
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

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

//	public List<Congregacao> getCongregacoes() {
//		return congregacoes;
//	}
//
//	public void setCongregacoes(List<Congregacao> congregacoes) {
//		this.congregacoes = congregacoes;
//	}

	public int getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(int idNucleo) {
		this.idNucleo = idNucleo;
	}

//	public Nucleo getNucleo() {
//		return nucleo;
//	}
//
//	public void setNucleo(Nucleo nucleo) {
//		this.nucleo = nucleo;
//	}

//	public Membro getMembro() {
//		return membro;
//	}
//
//	public void setMembro(Membro membro) {
//		this.membro = membro;
//	}
}