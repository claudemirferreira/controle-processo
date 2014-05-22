package br.com.ieadam.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.utils.PathRelatorios;

@ManagedBean
@SessionScoped
public class RelatorioEstatistico extends RelatorioGenerico implements
		Serializable {

	private static final long serialVersionUID = -4105629317145935510L;

	@Override
	public String telaRelatorio() {
		return "paginas/relatorio/estatistico.xhtml";
	}

	@Override
	public String nomeRelatorio() {
		return PathRelatorios.RELATORIO_SECRETARIA_MEMBROS.getNome();
	}

}