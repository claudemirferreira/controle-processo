package br.com.ieadam.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = -3267682267159820805L;

	private int id_menbro;
	
	private int id_perfil;
	
	@Id
	private String login;

	private String senha;
	
	private char ind_situacao;

	public int getId_menbro() {
		return id_menbro;
	}

	public void setId_menbro(int id_menbro) {
		this.id_menbro = id_menbro;
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getInd_situacao() {
		return ind_situacao;
	}

	public void setInd_situacao(char ind_situacao) {
		this.ind_situacao = ind_situacao;
	}	
}