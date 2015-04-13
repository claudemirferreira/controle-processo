package br.com.ieadam.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.utils.PathRelatorios;

@ManagedBean
@SessionScoped
public class RelatorioDebitoFinanceiro extends RelatorioGenerico implements
		Serializable {

	@Override
	public String telaRelatorio() {
		return "paginas/relatorio/debitofinanceiro.xhtml";
	}

	@Override
	public String nomeRelatorio() {
		return PathRelatorios.RELATORIO_TESOURARIA_DEBITO_FINANCEIRO.getNome();
	}
	
	@Override
	public String acaoUsuario() {
		return "GERACAO DE RELATORIO TESOURARIA DEBITO FINANCEIRO";
	}
}