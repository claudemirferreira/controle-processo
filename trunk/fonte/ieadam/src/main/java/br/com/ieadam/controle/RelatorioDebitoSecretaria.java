package br.com.ieadam.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.utils.PathRelatorios;

@ManagedBean
@SessionScoped
public class RelatorioDebitoSecretaria extends RelatorioGenerico implements
		Serializable {

	@Override
	public String telaRelatorio() {
		setVisualizar(false);
		return "paginas/relatorio/debitosecretaria.xhtml";
	}

	@Override
	public String nomeRelatorio() {
		return PathRelatorios.RELATORIO_SECRETARIA_DEBITO.getNome();
	}
}