package br.com.ieadam.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.utils.PathRelatorios;

@ManagedBean
@SessionScoped
public class RelatorioMembro extends RelatorioGenerico implements Serializable {

	@Override
	public String telaRelatorio() {
		return "paginas/relatorio/membro.xhtml";
	}

	@Override
	public String nomeRelatorio() {
		return PathRelatorios.RELATORIO_SECRETARIA_MEMBROS.getNome();
	}
}