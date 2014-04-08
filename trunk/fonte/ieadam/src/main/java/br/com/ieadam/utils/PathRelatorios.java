package br.com.ieadam.utils;

public enum PathRelatorios {
	RELATORIO_SECRETARIA_DEBITO("PENDENTE"), 
	RELATORIO_SECRETARIA_ESTATISTICO("CONCLUIDO"), 
	RELATORIO_SECRETARIA_MEMBROS("CANCELADO"),
	RELATORIO_SECRETARIA_DEBITO_PASTORAL("CANCELADO"),
    
	RELATORIO_TESOURARIA_SALDO_CONGREGACAO("/WEB-INF/jasper/RelatorioSaldoCongregacao.jasper"),
	RELATORIO_TESOURARIA_PROVENTOS_PASTORAL("/WEB-INF/jasper/RelatorioDemonstrativoProventos.jasper"),
	RELATORIO_TESOURARIA_DEBITO_FINANCEIRO(""),
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
