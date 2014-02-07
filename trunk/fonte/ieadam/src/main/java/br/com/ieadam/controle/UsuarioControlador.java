package br.com.ieadam.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.toolbar.Toolbar;
import org.primefaces.component.toolbar.ToolbarGroup;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.componentes.Util;
import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.servico.MembroServico;
import br.com.ieadam.utils.IEADAMAuthenticationManager;

@ManagedBean
@SessionScoped
public class UsuarioControlador {

	private Usuario usuario;

	private List<Perfil> perfis = new ArrayList<Perfil>();

	private Toolbar toolbarTeste;

	private ToolbarGroup toolbarGroupLeft;

	private CommandButton commandButton;

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	@ManagedProperty(value = "#{membroServicoImpl}")
	private MembroServico membroServico;

	private int colunas;
	
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
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Sample error message",
							"PrimeFaces makes no mistakes"));

			this.usuario = new Usuario();

			return "/login.xhtml?faces-redirect=true";
		} else {
			

			this.usuario = (Usuario) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			
			this.toolbarTeste = new Toolbar();
			this.toolbarGroupLeft = new ToolbarGroup();

			toolbarGroupLeft.setAlign("left");
			
			this.colunas = Util.definirTamanhoColuna(usuario.getPerfis().size());

			for (Perfil perfil : usuario.getPerfis()) {

				this.perfis.add(perfil);
				System.out.println(perfil.getNome());
				commandButton = new CommandButton();

				commandButton.setValue(perfil.getNome());
				commandButton.setUpdate(":form");
				// Metho

				commandButton
						.setAction(createMethodBinding("#{rotinaControlador.teste}"));

				toolbarGroupLeft.getChildren().add(commandButton);

			}

			toolbarTeste.getChildren().add(toolbarGroupLeft);

			return "/index.xhtml?faces-redirect=true";
		}
	}

	@SuppressWarnings("deprecation")
	private MethodBinding createMethodBinding(String action) {
		MethodBinding methodBinding = null;

		methodBinding = FacesContext.getCurrentInstance().getApplication()
				.createMethodBinding(action, null);

		return methodBinding;
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		this.usuario = new Usuario();

		this.paginaCentralControladorBean
				.setPaginaCentral("paginacentral.xhtml");
		;
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

	public MembroServico getMembroServico() {
		return this.membroServico;
	}

	public void setMembroServico(MembroServico membroServico) {
		this.membroServico = membroServico;
	}

	public Toolbar getToolbarTeste() {
		return toolbarTeste;
	}

	public void setToolbarTeste(Toolbar toolbarTeste) {
		this.toolbarTeste = toolbarTeste;
	}

	public ToolbarGroup getToolbarGroupLeft() {
		return toolbarGroupLeft;
	}

	public void setToolbarGroupLeft(ToolbarGroup toolbarGroupLeft) {
		this.toolbarGroupLeft = toolbarGroupLeft;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
}
