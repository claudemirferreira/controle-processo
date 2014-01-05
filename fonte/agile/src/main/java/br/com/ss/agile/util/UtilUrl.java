package br.com.ss.agile.util;

import java.io.Serializable;

public class UtilUrl implements Serializable {

	private static final long serialVersionUID = 1L;

// INICIO - TELAS GERAIS
	
	private final static String GERAL_PESQUISA_PROCESSO = "PESQUISA_PROCESSO";
	private final static String GERAL_PESQUISA_PROCESSO_URL = "/paginas/processo/pesquisa.xhtml";
	
// FIM - TELAS GERAIS	
	
// INICIO - TELAS REQUERIMENTO PROCESSO	
	
	// telas de tarefa
	private final static String REQUERIMENTO_TAREFA_ANEXAR_DOCUMENTOS = "ANEXAR_DOCUMENTOS";
	private final static String REQUERIMENTO_TAREFA_ANEXAR_DOCUMENTOS_URL = "/paginas/tarefa/requerimento/parecergap.xhtml";
	
	private final static String REQUERIMENTO_TAREFA_CONFIRMAR_NOTIFICACAO = "CONFIRMAR_NOTIFICACAO";
	private final static String REQUERIMENTO_TAREFA_CONFIRMAR_NOTIFICACAO_URL = "/paginas/tarefa/requerimento/parecergap.xhtml";

	private final static String REQUERIMENTO_TAREFA_PARECER_CARI = "PARECER_CARI";
	private final static String REQUERIMENTO_TAREFA_PARECER_CARI_URL = "/paginas/tarefa/requerimento/parecergap.xhtml";

	private final static String REQUERIMENTO_TAREFA_PESQUISA_TAREFA = "PESQUISA_TAREFA";
	private final static String REQUERIMENTO_TAREFA_PESQUISA_TAREFA_URL = "/paginas/tarefa/search.xhtml";

	// talas de processo
	private final static String REQUERIMENTO_PROCESSO_CADASTRO = "REQUERIMENTO_PROCESSO_CADASTRO";
	private final static String REQUERIMENTO_PROCESSO_CADASTRO_URL = "/paginas/processo/requerimento/cadastro.xhtml";
	
	private final static String REQUERIMENTO_PROCESSO_DETALHE = "REQUERIMENTO_PROCESSO_DETALHE";
	private final static String REQUERIMENTO_PROCESSO_DETALHE_URL = "/paginas/processo/requerimento/detalhe.xhtml";
	
	private final static String REQUERIMENTO_PROCESSO_ANEXAR_DOCUMENTOS = "REQUERIMENTO_PROCESSO_ANEXAR_DOCUMENTOS";
	private final static String REQUERIMENTO_PROCESSO_ANEXAR_DOCUMENTOS_URL = "/paginas/processo/requerimento/lista_documento.xhtml";
	
	private final static String REQUERIMENTO_PROCESSO_OK = "REQUERIMENTO_PROCESSO_OK";
	private final static String REQUERIMENTO_PROCESSO_OK_URL = "/paginas/processo/requerimento/sucesso.xhtml";
	
// FIM - TELAS REQUERIMENTO PROCESSO

	public static String getUrl(String tarefa) {

		if (tarefa.equals(REQUERIMENTO_TAREFA_ANEXAR_DOCUMENTOS))
			return REQUERIMENTO_TAREFA_ANEXAR_DOCUMENTOS_URL;

		else if (tarefa.equals(REQUERIMENTO_TAREFA_PARECER_CARI))
			return REQUERIMENTO_TAREFA_PARECER_CARI_URL;

		else if (tarefa.equals(REQUERIMENTO_TAREFA_PESQUISA_TAREFA))
			return REQUERIMENTO_TAREFA_PESQUISA_TAREFA_URL;
		
		else if (tarefa.equals(REQUERIMENTO_TAREFA_CONFIRMAR_NOTIFICACAO))
			return REQUERIMENTO_TAREFA_CONFIRMAR_NOTIFICACAO_URL;
		
		return null;

	}

	public static String getRequerimentoTarefaAnexarDocumentos() {
		return REQUERIMENTO_TAREFA_ANEXAR_DOCUMENTOS;
	}

	public static String getRequerimentoTarefaAnexarDocumentosUrl() {
		return REQUERIMENTO_TAREFA_ANEXAR_DOCUMENTOS_URL;
	}

	public static String getRequerimentoTarefaParecerCari() {
		return REQUERIMENTO_TAREFA_PARECER_CARI;
	}

	public static String getRequerimentoParecerCariUrl() {
		return REQUERIMENTO_TAREFA_PARECER_CARI_URL;
	}

	public static String getRequerimentoPesquisaTarefa() {
		return REQUERIMENTO_TAREFA_PESQUISA_TAREFA;
	}

	public static String getRequerimentoPesquisaTarefaUrl() {
		return REQUERIMENTO_TAREFA_PESQUISA_TAREFA_URL;
	}

	public static String getRequerimentoProcessoCadastro() {
		return REQUERIMENTO_PROCESSO_CADASTRO;
	}

	public static String getRequerimentoProcessoCadastroUrl() {
		return REQUERIMENTO_PROCESSO_CADASTRO_URL;
	}

	public static String getRequerimentoProcessoDetalhe() {
		return REQUERIMENTO_PROCESSO_DETALHE;
	}

	public static String getRequerimentoProcessoDetalheUrl() {
		return REQUERIMENTO_PROCESSO_DETALHE_URL;
	}
	
	public static String getRequerimentoProcessoAnexarDocumentos() {
		return REQUERIMENTO_PROCESSO_ANEXAR_DOCUMENTOS;
	}

	public static String getRequerimentoProcessoAnexarDocumentosUrl() {
		return REQUERIMENTO_PROCESSO_ANEXAR_DOCUMENTOS_URL;
	}
	
	public static String getRequerimentoProcessoOk() {
		return REQUERIMENTO_PROCESSO_OK;
	}

	public static String getRequerimentoProcessoOkUrl() {
		return REQUERIMENTO_PROCESSO_OK_URL;
	}
	
	public static String getPesquisaProcesso() {
		return GERAL_PESQUISA_PROCESSO;
	}

	public static String getPesquisaProcessoUrl() {
		return GERAL_PESQUISA_PROCESSO_URL;
	}

	public static String getRequerimentoTarefaConfirmarNotificacao() {
		return REQUERIMENTO_TAREFA_CONFIRMAR_NOTIFICACAO;
	}

	public static String getRequerimentoTarefaConfirmarNotificacaoUrl() {
		return REQUERIMENTO_TAREFA_CONFIRMAR_NOTIFICACAO_URL;
	}

}
