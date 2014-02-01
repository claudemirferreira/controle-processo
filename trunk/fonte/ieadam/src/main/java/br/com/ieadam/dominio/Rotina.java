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

	public static List<Rotina> getModuloTesouraria() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("SALDO DA CONGREGAÇÃO", "DESCRICAO", "tesourariaSaldoCongregacao.show()", "resources/imagens/rotina/banknote.png");
		list.add(rotina);

		rotina = new Rotina("PROVENTO PASTORAL", "DESCRICAO", "tesourariaProventoPastoral.show()", "resources/imagens/rotina/bar_chart.png");
		list.add(rotina);

		rotina = new Rotina("DÉBITO FINANCEIRO", "DESCRICAO", "tesourariaDebitoFinanceiro.show()", "resources/imagens/rotina/calculator.png");
		list.add(rotina);

		rotina = new Rotina("CENTRO DE CUSTO", "DESCRICAO", "tesourariaCentroCusto.show()", "resources/imagens/rotina/cash_register.png");
		list.add(rotina);
		
		rotina = new Rotina("NADA CONSTA", "DESCRICAO", "tesourariaNadaConsta.show()", "resources/imagens/rotina/coins.png");
		list.add(rotina);

		rotina = new Rotina("SALDO DEPARTAMENTAL", "DESCRICAO", "tesourariaSaldoDepartamental.show()", "resources/imagens/rotina/credit_card.png");
		list.add(rotina);

		rotina = new Rotina("BALANCETE ANALITICO", "DESCRICAO", "tesourariaBalanceteAnalitico.show()", "resources/imagens/rotina/gold_bullion.png");
		list.add(rotina);

		rotina = new Rotina("BALANCETE SINTÉTICO", "DESCRICAO", "tesourariaBalanceteSintetico.show()", "resources/imagens/rotina/invoice.png");
		list.add(rotina);

		return list;
	}

	public static List<Rotina> getModuloSecretaria() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("DÉBITO SECRETARIA", "DESCRICAO", "debitoSecretaria.show()", "resources/imagens/rotina/banknote.png");
		list.add(rotina);

		rotina = new Rotina("ESTATÍSTICO", "DESCRICAO", "estatistico", "resources/imagens/rotina/bar_chart.png");
		list.add(rotina);

		rotina = new Rotina("MEMBROS", "DESCRICAO", "ACAO", "resources/imagens/rotina/calculator.png");
		list.add(rotina);

		rotina = new Rotina("DÉBITO PASTORAL", "DESCRICAO", "ACAO", "resources/imagens/rotina/cash_register.png");
		list.add(rotina);

		return list;
	}


}
