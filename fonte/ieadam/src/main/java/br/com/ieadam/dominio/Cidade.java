package br.com.ieadam.dominio;

import java.util.Date;

public class Cidade {

	private int id_cidade;
	
	private String Nome;
	
	private String UF;
	
	private Character ind_Situacao;
	
	private Date data_ult_atu;

	public int getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
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
