package br.com.ieadam.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PaginaCentralControladorBean implements Serializable{

	private static final long serialVersionUID = -1155931039018244331L;
	
	private String paginaCentral;
	
	public PaginaCentralControladorBean() {
		setPaginaCentral("paginas/perfil/lista.xhtml");
	}

	public String getPaginaCentral() {
		return paginaCentral;
	}

	public void setPaginaCentral(String paginaCentral) {
		this.paginaCentral = paginaCentral;
	}
	
	public String index(){
		return "index.xhtml";
	}
	
}