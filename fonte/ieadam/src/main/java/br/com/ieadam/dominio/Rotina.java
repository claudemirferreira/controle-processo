package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rotina implements Serializable {

	private static final long serialVersionUID = 8724103892548378330L;

	private String nome;

	private String descricao;

	private String acao;

	private String imagem;
	
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Rotina(String nome, String descricao, String acao, String imagem) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.acao = acao;
		this.imagem = imagem;
	}

	public static List<Rotina> getModulo1() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("ROTINA1", "DESCRICAO", "ACAO", "resources/imagens/rotina/banknote.png");
		list.add(rotina);

		rotina = new Rotina("ROTINA2", "DESCRICAO", "ACAO", "resources/imagens/rotina/bar_chart.png");
		list.add(rotina);

		rotina = new Rotina("ROTINA3", "DESCRICAO", "ACAO", "resources/imagens/rotina/calculator.png");
		list.add(rotina);

		rotina = new Rotina("ROTINA4", "DESCRICAO", "ACAO", "resources/imagens/rotina/cash_register.png");
		list.add(rotina);
		
		rotina = new Rotina("ROTINA5", "DESCRICAO", "ACAO", "resources/imagens/rotina/coins.png");
		list.add(rotina);

		rotina = new Rotina("ROTINA6", "DESCRICAO", "ACAO", "resources/imagens/rotina/credit_card.png");
		list.add(rotina);

		rotina = new Rotina("ROTINA7", "DESCRICAO", "ACAO", "resources/imagens/rotina/gold_bullion.png");
		list.add(rotina);

		rotina = new Rotina("ROTINA8", "DESCRICAO", "ACAO", "resources/imagens/rotina/invoice.png");
		list.add(rotina);

		return list;
	}

	public static List<Rotina> getModulo2() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("ROTINA1", "DESCRICAO", "ACAO", "resources/imagens/rotina/banknote.png");
		list.add(rotina);

		rotina = new Rotina("ROTINA2", "DESCRICAO", "ACAO", "resources/imagens/rotina/bar_chart.png");
		list.add(rotina);

		rotina = new Rotina("ROTINA3", "DESCRICAO", "ACAO", "resources/imagens/rotina/calculator.png");
		list.add(rotina);

		rotina = new Rotina("ROTINA4", "DESCRICAO", "ACAO", "resources/imagens/rotina/cash_register.png");
		list.add(rotina);

		return list;
	}

	public static List<Rotina> getModulo3() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("ROTINA9", "DESCRICAO", "ACAO", "resources/imagens/rotina/");
		list.add(rotina);

		rotina = new Rotina("ROTINA10", "DESCRICAO", "ACAO", "resources/imagens/rotina/");
		list.add(rotina);

		rotina = new Rotina("ROTINA11", "DESCRICAO", "ACAO", "resources/imagens/rotina/");
		list.add(rotina);

		rotina = new Rotina("ROTINA12", "DESCRICAO", "ACAO", "resources/imagens/rotina/");
		list.add(rotina);

		return list;
	}

}
