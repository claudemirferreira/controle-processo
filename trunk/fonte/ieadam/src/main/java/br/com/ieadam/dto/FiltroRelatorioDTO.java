package br.com.ieadam.dto;

import java.io.Serializable;

import br.com.ieadam.dominio.Usuario;

public class FiltroRelatorioDTO implements Serializable {

	private static final long serialVersionUID = 3229078578713401437L;

	private String tipoRelatorio;

	private String dataInicial;

	private String dataFinal;

	private Usuario usuarioLogado;

	private Usuario membro;

	public String getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(String tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Usuario getMembro() {
		return membro;
	}

	public void setMembro(Usuario membro) {
		this.membro = membro;
	}
}
