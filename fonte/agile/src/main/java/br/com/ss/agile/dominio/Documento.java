package br.com.ss.agile.dominio;

public class Documento extends Arquivo {

	private static final long serialVersionUID = 1L;

	private TipoDocumento tipoDocumento;

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
}
