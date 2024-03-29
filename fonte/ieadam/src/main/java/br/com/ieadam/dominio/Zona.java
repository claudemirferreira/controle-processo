package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "ieadam_zona")
public class Zona extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -6148396536721220451L;

	@Id
	private int idZona;

	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

	@Column(nullable = false, length = 60)
	private String nome;

	@Column(name = "situacao", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String situacao;

	@Column
	private int idPrimeiroResp;

	@Column
	private int idSegundoResp;

	@Transient
	private boolean membro;

	@Transient
	private boolean usuarioZona;

	@OneToMany(mappedBy = "zona")
	private List<UsuarioZona> usuarioZonas;

	@Override
	public int getId() {
		return idZona;
	}

	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
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

	public int getIdPrimeiroResp() {
		return idPrimeiroResp;
	}

	public void setIdPrimeiroResp(int idPrimeiroResp) {
		this.idPrimeiroResp = idPrimeiroResp;
	}

	public int getIdSegundoResp() {
		return idSegundoResp;
	}

	public void setIdSegundoResp(int idSegundoResp) {
		this.idSegundoResp = idSegundoResp;
	}

	public boolean isMembro() {
		return membro;
	}

	public void setMembro(boolean membro) {
		this.membro = membro;
	}

	public boolean isUsuarioZona() {
		return usuarioZona;
	}

	public void setUsuarioZona(boolean usuarioZona) {
		this.usuarioZona = usuarioZona;
	}

	public List<UsuarioZona> getUsuarioZonas() {
		return usuarioZonas;
	}

	public void setUsuarioZonas(List<UsuarioZona> usuarioZonas) {
		this.usuarioZonas = usuarioZonas;
	}

}