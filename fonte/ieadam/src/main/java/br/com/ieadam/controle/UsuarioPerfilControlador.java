package br.com.ieadam.controle;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioPerfil;
import br.com.ieadam.servico.PerfilServico;
import br.com.ieadam.servico.UsuarioPerfilServico;
import br.com.ieadam.servico.UsuarioServico;

@ManagedBean
@SessionScoped
public class UsuarioPerfilControlador {

	private final String TELA_MANUTENCAO = "paginas/usuario/manutencao.xhtml";
	private final String TELA_PESQUISA = "paginas/usuario/pesquisa.xhtml";

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	@ManagedProperty(value = "#{perfilServicoImpl}")
	private PerfilServico perfilServico;

	@ManagedProperty(value = "#{usuarioServicoImpl}")
	private UsuarioServico usuarioServico;

	@ManagedProperty(value = "#{usuarioPerfilServicoImpl}")
	private UsuarioPerfilServico usuarioPerfilServico;

	private List<Perfil> listaPerfis;
	
	private Usuario usuario;

    private DualListModel<UsuarioPerfil> dualListPerfil;  
    

	private List<UsuarioPerfil> listaUsuPerfilNotInUsuario;
  
	@PostConstruct
	public void init() {
		this.listaPerfis = perfilServico.listarTodos();
		
		listaUsuPerfilNotInUsuario = usuarioPerfilServico.listarTodos();
//				usuarioPerfilServico.listaPerfisDiferentesUsuario(usuario); // TODO
		
		usuario = usuarioServico.findByLogin("admin");	// TODO
		
		dualListPerfil = new DualListModel<UsuarioPerfil>(listaUsuPerfilNotInUsuario, usuario.getUsuarioPerfil());
		
	}
	

	public void onTransfer(TransferEvent event) {  
		
		// TODO
		
		FacesMessage msg = new FacesMessage();  
        msg.setSeverity(FacesMessage.SEVERITY_INFO);  
        msg.setSummary("Items Transferred");  
        msg.setDetail(">>>>");  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
		
		
	}
	
	
	
	public void manterUsuario(Usuario usuario) {
		this.usuario = usuario;
		
		for (Perfil perfil : this.listaPerfis ) {
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
			UsuarioPerfil usuarioPerfil = usuario.getUsuarioPerfilByPerfil(perfil);
			if (!usuario.containsPerfil(perfil)) {
				if (perfil.isChecked()) {
					usuario.getUsuarioPerfil().add(createUsuarioPerfil(perfil));
				} else if ( usuarioPerfil != null ) {
						usuarioPerfilServico.remover(usuarioPerfil);
						usuario.getUsuarioPerfil().remove(usuarioPerfil);
				}
			} else if (!perfil.isChecked()) {
				usuarioPerfilServico.remover(usuarioPerfil);
				usuario.getUsuarioPerfil().remove(usuarioPerfil);
			}
		}

		this.usuarioServico.salvar(usuario);
		retornar();
		
		// TODO mostrar msg sucesso: GrowMessage
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

	public UsuarioServico getUsuarioServico() {
		return usuarioServico;
	}

	public void setUsuarioServico(UsuarioServico usuarioServico) {
		this.usuarioServico = usuarioServico;
	}


	public PerfilServico getPerfilServico() {
		return perfilServico;
	}

	public void setPerfilServico(PerfilServico perfilServico) {
		this.perfilServico = perfilServico;
	}

	public UsuarioPerfilServico getUsuarioPerfilServico() {
		return usuarioPerfilServico;
	}

	public void setUsuarioPerfilServico(UsuarioPerfilServico usuarioPerfilServico) {
		this.usuarioPerfilServico = usuarioPerfilServico;
	}

    public DualListModel<UsuarioPerfil> getDualListPerfil() {
		return dualListPerfil;
	}

	public void setDualListPerfil(DualListModel<UsuarioPerfil> dualListPerfil) {
		this.dualListPerfil = dualListPerfil;
	}
}
