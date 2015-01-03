package br.com.ieadam.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "view_membro")
@Immutable
public class ViewMembro {

	@Id
	@Column
	private int idMembro;

	@Column
	private String membro;
	
	@Column
	private Integer idArea;

	@Column
	private String area;
	
	@Column
	private Integer idNucleo;

	@Column
	private String nucleo;

	@Column
	private Integer idZona;

	@Column
	private String zona;
	
//	@Column
//	private Date dataNascimento;
//	
//	@Column
//	private String funcao;
//
//	@Column
//	private String congregacao;
//
//	@Column
//	private String pastor;
//	
//	@Column
//	private String estadoCivil;
//
//	@Column
//	private String conjuge;
//	
//	@Column
//	private String recebidoPor;
//
//	@Column
//	private String dataBatismo;
//
//	@Column
//	private String procedencia;
//
//	@Column
//	private String situacao;
//
//	@Column
//	private String endereco;
//
//	@Column
//	private String bairro;
//
//	@Column
//	private String telefone;
	
	public int getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(int idMembro) {
		this.idMembro = idMembro;
	}

	public String getMembro() {
		return membro;
	}

	public void setMembro(String membro) {
		this.membro = membro;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(Integer idNucleo) {
		this.idNucleo = idNucleo;
	}

	public String getNucleo() {
		return nucleo;
	}

	public void setNucleo(String nucleo) {
		this.nucleo = nucleo;
	}

	public Integer getIdZona() {
		return idZona;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

//	public Date getDataNascimento() {
//		return dataNascimento;
//	}
//
//	public void setDataNascimento(Date dataNascimento) {
//		this.dataNascimento = dataNascimento;
//	}
//
//	public String getFuncao() {
//		return funcao;
//	}
//
//	public void setFuncao(String funcao) {
//		this.funcao = funcao;
//	}
//
//	public String getCongregacao() {
//		return congregacao;
//	}
//
//	public void setCongregacao(String congregacao) {
//		this.congregacao = congregacao;
//	}
//
//	public String getPastor() {
//		return pastor;
//	}
//
//	public void setPastor(String pastor) {
//		this.pastor = pastor;
//	}
//
//	public String getEstadoCivil() {
//		return estadoCivil;
//	}
//
//	public void setEstadoCivil(String estadoCivil) {
//		this.estadoCivil = estadoCivil;
//	}
//
//	public String getConjuge() {
//		return conjuge;
//	}
//
//	public void setConjuge(String conjuge) {
//		this.conjuge = conjuge;
//	}
//
//	public String getRecebidoPor() {
//		return recebidoPor;
//	}
//
//	public void setRecebidoPor(String recebidoPor) {
//		this.recebidoPor = recebidoPor;
//	}
//
//	public String getDataBatismo() {
//		return dataBatismo;
//	}
//
//	public void setDataBatismo(String dataBatismo) {
//		this.dataBatismo = dataBatismo;
//	}
//
//	public String getProcedencia() {
//		return procedencia;
//	}
//
//	public void setProcedencia(String procedencia) {
//		this.procedencia = procedencia;
//	}
//
//	public String getSituacao() {
//		return situacao;
//	}
//
//	public void setSituacao(String situacao) {
//		this.situacao = situacao;
//	}
//
//	public String getEndereco() {
//		return endereco;
//	}
//
//	public void setEndereco(String endereco) {
//		this.endereco = endereco;
//	}
//
//	public String getBairro() {
//		return bairro;
//	}
//
//	public void setBairro(String bairro) {
//		this.bairro = bairro;
//	}
//
//	public String getTelefone() {
//		return telefone;
//	}
//
//	public void setTelefone(String telefone) {
//		this.telefone = telefone;
//	}
}