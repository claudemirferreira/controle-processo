package br.com.ieadam.utils;

public enum PathRelatorios {
	RELATORIO_SECRETARIA_DEBITO("/WEB-INF/jasper/RelatorioDebitoSecretaria.jasper"), 
	RELATORIO_SECRETARIA_ESTATISTICO("/WEB-INF/jasper/RelatorioEstatistico.jasper"), 
	RELATORIO_SECRETARIA_MEMBROS("/WEB-INF/jasper/RelatorioFichaMembro.jasper"),
	RELATORIO_SECRETARIA_DEBITO_PASTORAL("/WEB-INF/jasper/RelatorioDebitoPastoral.jasper"),
    
	RELATORIO_TESOURARIA_SALDO_CONGREGACAO("/WEB-INF/jasper/RelatorioSaldoCongregacao.jasper"),
	RELATORIO_TESOURARIA_PROVENTOS_PASTORAL("/WEB-INF/jasper/RelatorioDemonstrativoProventos.jasper"),
	RELATORIO_TESOURARIA_DEBITO_FINANCEIRO("/WEB-INF/jasper/RelatorioDebitoFinanceiro.jasper"),
	RELATORIO_TESOURARIA_BALANCETE_SINTETICO(""),
	RELATORIO_TESOURARIA_BALANCETE_ANALITICO(""),
	RELATORIO_TESOURARIA_CENTRO_CUSTO(""),
	RELATORIO_TESOURARIA_NADA_CONSTA(""),
	RELATORIO_TESOURARIA_SALDO_DEPARTAMENTO("");
	
    private final String nome;

    PathRelatorios(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
