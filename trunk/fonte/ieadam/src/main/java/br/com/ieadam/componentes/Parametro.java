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

	private Mes mesInicio = Mes.JANEIRO;

	private int anoInicio;

	private Mes mesFim = Mes.JANEIRO;

	private int anoFim;

	private String usuario;

	private List<Mes> meses = new ArrayList<Mes>();

	private String dataInicio;
	
	private String dataFim;
	
	public Parametro() {
		this.ano = DataUtil.pegarAnocorrente();

		this.anoInicio = this.ano;
		this.anoFim = this.ano;

		this.mesFim = DataUtil.pegarMescorrente();
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

	public Mes getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(Mes mesInicio) {
		this.mesInicio = mesInicio;
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}

	public Mes getMesFim() {
		return mesFim;
	}

	public void setMesFim(Mes mesFim) {
		this.mesFim = mesFim;
	}

	public int getAnoFim() {
		return anoFim;
	}

	public void setAnoFim(int anoFim) {
		this.anoFim = anoFim;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

}