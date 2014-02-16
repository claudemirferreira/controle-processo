package br.com.ieadam.controle;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioPerfil;
import br.com.ieadam.servico.PerfilServico;
import br.com.ieadam.servico.UsuarioServico;

@ManagedBean
@SessionScoped
public class UsuarioPerfilControlador {

	private final String TELA_MANUTENCAO = "paginas/usuario/manutencao.xhtml";
	private final String TELA_PESQUISA = "paginas/usuario/pesquisa.xhtml";

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	@ManagedProperty(value = "#{perfilServicoImpl}")
	private PerfilServico servicoPerfil;

	@ManagedProperty(value = "#{usuarioServicoImpl}")
	private UsuarioServico servicoUsuario;
	
	private List<Perfil> listaPerfis;
	
	private Usuario usuario;

	
	@PostConstruct
	public void init() {
		listaPerfis = servicoPerfil.listarTodos();
	}
	

	public void manterUsuario(Usuario usuario) {
		this.usuario = usuario;
		
		for (Perfil perfil : listaPerfis ) {
			// marca os perfis existentes
			perfil.setChecked(usuario.containsPerfil(perfil));
		}
		
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_MANUTENCAO);
	}
	

	public void retornar() {
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_PESQUISA);
	}

	
	public void salvar() {
		
		for (Perfil perfil : listaPerfis ) {
			if (!usuario.containsPerfil(perfil)) {
				if (perfil.isChecked()) {
					usuario.getUsuarioPerfils().add(createUsuarioPerfil(perfil));
				} else {
					usuario.getUsuarioPerfils().remove(usuario.getUsuarioPerfilByPerfil(perfil));
				}
			}
		}

		this.servicoUsuario.salvar(usuario);
		retornar();
		
		// TODO mostrar msg sucesso: GrowMessage
		
		// TODO id de usuarioPerfil esta vindo zerado
		// estah incluindo novo inves de atualizar
	}

	
	private UsuarioPerfil createUsuarioPerfil(Perfil perfil) {
		UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
		usuarioPerfil.setData(new Date());
		usuarioPerfil.setPerfil(perfil);
		usuarioPerfil.setUsuario(usuario);
		return usuarioPerfil;
	}


	/* ---------- Gets/Sets --------------- */

	public List<Perfil> getListaPerfis() {
		return listaPerfis;
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}


	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
	}


	public PerfilServico getServicoPerfil() {
		return servicoPerfil;
	}


	public void setServicoPerfil(PerfilServico servicoPerfil) {
		this.servicoPerfil = servicoPerfil;
	}


	public UsuarioServico getServicoUsuario() {
		return servicoUsuario;
	}


	public void setServicoUsuario(UsuarioServico servicoUsuario) {
		this.servicoUsuario = servicoUsuario;
	}
	
	

}
