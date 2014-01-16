package br.com.ieadam.controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.dominio.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioControlador {

	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		this.usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
