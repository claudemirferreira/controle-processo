package br.com.ieadam.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.utils.PathRelatorios;

@ManagedBean
@SessionScoped
public class RelatorioNadaConsta extends RelatorioGenerico implements
		Serializable {

	@Override
	public String telaRelatorio() {
		return "paginas/relatorio/nadaconsta.xhtml";
	}

	@Override
	public String nomeRelatorio() {
		return PathRelatorios.RELATORIO_TESOURARIA_NADA_CONSTA.getNome();
	}
	
	@Override
	public String acaoUsuario() {
		return "GERACAO DE RELATORIO TESOURARIA NADA CONSTA";
	}
}