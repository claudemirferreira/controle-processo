package br.com.ieadam.controle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.utils.IEADAMAuthenticationManager;

@ManagedBean
@SessionScoped
public class UsuarioControlador {

	private Usuario usuario;
	
	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	@ManagedProperty(value = "#{IEADAMAuthenticationManager}")
	private IEADAMAuthenticationManager IEADAMAuthenticationManager;

	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
	}

	public String logar() {

		Authentication authenticatedUser = this.IEADAMAuthenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(
						this.usuario.getLogin(), this.usuario.getSenha()));

		if (authenticatedUser == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample error message", "PrimeFaces makes no mistakes"));
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ", "Usuario ou Senha invalido"));
			
			this.usuario = new Usuario();
			
			return "/login.xhtml?faces-redirect=true";
		} else {
			
			this.usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			return "/index.xhtml?faces-redirect=true";
		}
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		this.usuario = new Usuario();
		
		this.paginaCentralControladorBean.setPaginaCentral("paginacentral.xhtml");;
		return "login.xhtml?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}

	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
	}

	public IEADAMAuthenticationManager getIEADAMAuthenticationManager() {
		return IEADAMAuthenticationManager;
	}

	public void setIEADAMAuthenticationManager(
			IEADAMAuthenticationManager iEADAMAuthenticationManager) {
		IEADAMAuthenticationManager = iEADAMAuthenticationManager;
	}
}
