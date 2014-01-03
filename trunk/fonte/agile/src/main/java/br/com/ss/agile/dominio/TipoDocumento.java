package br.com.ss.agile.dominio;

public enum TipoDocumento {

    DOCUMENTO_IDENTIFICACAO("DOCUMENTO DE IDENTIFICACAO"), COMPROVANTE_RESIDENCIA("COMPROVANTE DE RESIDENCIA"), 
    AUTO_DE_INFRACAO("AUTO DE INFRACAO"), TERMO_DE_APREENSAO("TERMO DE APREENSAO"), CRLV("CERTIFICADO DE REGISTRO DO VEICULO - CRLV"),
    CNPJ("CNPJ"), CONTRATO_SOCIAL("CONTRATO SOCIAL"), FORMULARIO_DE_REQUERIMENTO("FORMULARIO DE REQUERIMENTO");

    private final String nome;

    TipoDocumento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
