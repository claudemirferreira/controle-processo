package br.com.ieadam.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PaginaCentralControladorBean {

	private String paginaCentral;
	
	public PaginaCentralControladorBean() {
		setPaginaCentral("paginacentral.xhtml");
	}

	public String getPaginaCentral() {
		return paginaCentral;
	}

	public void setPaginaCentral(String paginaCentral) {
		this.paginaCentral = paginaCentral;
	}
	
	public void teste(){
		
		System.out.println("www");
	}
	
}
