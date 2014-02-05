package br.com.ieadam.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Rotina;

@ManagedBean
@SessionScoped
public class RotinaControlador implements Serializable {

	private static final long serialVersionUID = -6832271293709421841L;

	private Rotina rotina;

	private List<Rotina> moduloSecretaria;

	private List<Rotina> moduloTesouraria;
	
	private List<Rotina> moduloAdministrativo;

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	public RotinaControlador() {
		this.moduloSecretaria = Rotina.getModuloSecretaria();
		this.moduloTesouraria = Rotina.getModuloTesouraria();
		this.moduloAdministrativo = Rotina.getModuloAdministrativo();

	}

	public void telaRelatorio(Rotina rotina) {
		this.paginaCentralControladorBean.setPaginaCentral(rotina.getAcao());
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

	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}

	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
	}

	public List<Rotina> getModuloAdministrativo() {
		return moduloAdministrativo;
	}

	public void setModuloAdministrativo(List<Rotina> moduloAdministrativo) {
		this.moduloAdministrativo = moduloAdministrativo;
	}

}