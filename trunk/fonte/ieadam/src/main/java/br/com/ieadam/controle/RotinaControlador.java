package br.com.ieadam.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Rotina;

@ManagedBean
@SessionScoped
public class RotinaControlador {

	private Rotina rotina;

	private List<Rotina> moduloSecretaria;

	private List<Rotina> moduloTesouraria;

	public RotinaControlador() {

		this.moduloSecretaria = Rotina.getModuloSecretaria();

		this.moduloTesouraria = Rotina.getModuloTesouraria();

	}

	public Rotina getRotina() {
		return rotina;
	}

	public void setRotina(Rotina rotina) {
		this.rotina = rotina;
	}

	public List<Rotina> getModuloSecretaria() {
		return moduloSecretaria;
	}

	public void setModuloSecretaria(List<Rotina> moduloSecretaria) {
		this.moduloSecretaria = moduloSecretaria;
	}

	public List<Rotina> getModuloTesouraria() {
		return moduloTesouraria;
	}

	public void setModuloTesouraria(List<Rotina> moduloTesouraria) {
		this.moduloTesouraria = moduloTesouraria;
	}

}
