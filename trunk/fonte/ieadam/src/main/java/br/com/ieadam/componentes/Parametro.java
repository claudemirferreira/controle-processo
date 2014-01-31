package br.com.ieadam.componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.ieadam.dominio.Mes;

public class Parametro implements Serializable {

	private static final long serialVersionUID = -5744163825663878145L;

	private Mes mes = Mes.JANEIRO;

	private int ano;

	private List<Mes> meses = new ArrayList<Mes>();

	public Parametro() {
		this.ano = DataUtil.pegarAnocorrente();
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public List<Mes> getMeses() {
		return Arrays.asList(Mes.values());
	}

	public void setMeses(List<Mes> meses) {
		this.meses = meses;
	}

}