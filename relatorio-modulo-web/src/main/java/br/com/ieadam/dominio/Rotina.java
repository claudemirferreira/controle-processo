package br.com.ieadam.dominio;

import java.util.ArrayList;
import java.util.List;

public class Rotina {

	private String nome;

	private String descricao;

	private String acao;

	private String foto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Rotina(String nome, String descricao, String acao, String foto) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.acao = acao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public static List<Rotina> getModulo1() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("ROTINA1", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		rotina = new Rotina("ROTINA2", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		rotina = new Rotina("ROTINA3", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		rotina = new Rotina("ROTINA4", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		return list;
	}

	public static List<Rotina> getModulo2() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("ROTINA5", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		rotina = new Rotina("ROTINA6", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		rotina = new Rotina("ROTINA7", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		rotina = new Rotina("ROTINA8", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		return list;
	}

	public static List<Rotina> getModulo3() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("ROTINA9", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		rotina = new Rotina("ROTINA10", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		rotina = new Rotina("ROTINA11", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		rotina = new Rotina("ROTINA12", "DESCRICAO", "ACAO", "");
		list.add(rotina);

		return list;
	}

}
