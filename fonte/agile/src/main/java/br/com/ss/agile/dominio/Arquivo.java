package br.com.ss.agile.dominio;

import java.io.Serializable;

import org.primefaces.model.UploadedFile;

public class Arquivo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String uuid;
	private UploadedFile file;
	private String processoId;
	private String nomeArquivo;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getProcessoId() {
		return processoId;
	}

	public void setProcessoId(String processoId) {
		this.processoId = processoId;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
}