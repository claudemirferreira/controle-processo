package br.com.ieadam.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ieadam_cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String Nome;

	private String UF;

	private Character ind_Situacao;

	private Date data_ult_atu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public Character getInd_Situacao() {
		return ind_Situacao;
	}

	public void setInd_Situacao(Character ind_Situacao) {
		this.ind_Situacao = ind_Situacao;
	}

	public Date getData_ult_atu() {
		return data_ult_atu;
	}

	public void setData_ult_atu(Date data_ult_atu) {
		this.data_ult_atu = data_ult_atu;
	}
}
