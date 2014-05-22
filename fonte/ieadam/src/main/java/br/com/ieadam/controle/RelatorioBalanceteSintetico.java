package br.com.ieadam.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.utils.PathRelatorios;

@ManagedBean
@SessionScoped
public class RelatorioBalanceteSintetico extends RelatorioGenerico implements
		Serializable {

	@Override
	public String telaRelatorio() {
		return "paginas/relatorio/balancetesintetico.xhtml";
	}

	@Override
	public String nomeRelatorio() {
		return PathRelatorios.RELATORIO_TESOURARIA_BALANCETE_SINTETICO
				.getNome();
	}

}