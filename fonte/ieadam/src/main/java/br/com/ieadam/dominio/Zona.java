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
@Table(name = "ieadam_zona")
public class Zona extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -6148396536721220451L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idZona;

	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

	@Column(nullable = false, length = 60)
	private String nome;

	@Column(name = "situacao", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String situacao;

	@ManyToOne
	@JoinColumn(name = "id_membro", nullable = false)
	private Membro membro;

	private int cd_ZonaArgo;

	@Override
	public Long getId() {
		return idZona;
	}

	public Long getIdZona() {
		return idZona;
	}

	public void setIdZona(Long idZona) {
		this.idZona = idZona;
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

	public int getCd_ZonaArgo() {
		return cd_ZonaArgo;
	}

	public void setCd_ZonaArgo(int cd_ZonaArgo) {
		this.cd_ZonaArgo = cd_ZonaArgo;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}
}