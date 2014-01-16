package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rotina implements Serializable{
	
	private static final long serialVersionUID = 8724103892548378330L;

	private String nome;
	
	private String descricao;
	
	private String acao;

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
	
	public Rotina(String nome, String descricao, String acao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.acao = acao;
	}

	public static List<Rotina> getModulo1(){
		
		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("ROTINA1","DESCRICAO","ACAO");
		list.add(rotina);
		
		rotina = new Rotina("ROTINA2","DESCRICAO","ACAO");
		list.add(rotina);
		
		rotina = new Rotina("ROTINA3","DESCRICAO","ACAO");
		list.add(rotina);
		
		rotina = new Rotina("ROTINA4","DESCRICAO","ACAO");
		list.add(rotina);
		
		
		return list;
	}

}
