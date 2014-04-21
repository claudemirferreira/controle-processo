package br.com.ieadam.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Sistema;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.servico.MembroServico;
import br.com.ieadam.servico.SistemaServico;
import br.com.ieadam.servico.UsuarioServico;
import br.com.ieadam.utils.IEADAMAuthenticationManager;

@ManagedBean
@SessionScoped
public class UsuarioControlador {

	private Usuario entidade;

	private Usuario pesquisa;

	private Usuario usuario;

	private Sistema sistema;

	private List<Usuario> lista;

	private List<Perfil> perfis = new ArrayList<Perfil>();

	@ManagedProperty(value = "#{usuarioServicoImpl}")
	private UsuarioServico servico;

	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;

	@ManagedProperty(value = "#{membroServicoImpl}")
	private MembroServico membroServico;

	@ManagedProperty(value = "#{sistemaServicoImpl}")
	private SistemaServico sistemaServico;

	@ManagedProperty(value = "#{perfilControlador}")
	private PerfilControlador perfilControlador;

	private int colunas;

	@ManagedProperty(value = "#{IEADAMAuthenticationManager}")
	private IEADAMAuthenticationManager IEADAMAuthenticationManager;

	private final String TELA_CADASTRO = "paginas/usuario/cadastro.xhtml";
	private final String TELA_PESQUISA = "paginas/usuario/pesquisa.xhtml";

	public void init() {
		this.sistema = sistemaServico.findByCodigo("IEADAM");
		this.lista = servico.listarTodos();
		this.telaPesquisa();

	}

	public UsuarioControlador() {
		this.usuario = new Usuario();
		this.entidade = new Usuario();
		this.pesquisa = new Usuario();

	}

	public void pesquisar() {
		// this.lista = this.servico.findBy(this.pesquisa.getLogin());
	}

	public void detalhe(Usuario usuario) {
		this.entidade = usuario;

		// this.entidade.setPastor(pastorServico.findByUsuario(usuario));
		// this.pastores = pastorServico.listarTodos();
		this.telaCadastro();
	}

	public void salvar() {
		this.servico.salvar(this.entidade);
		this.lista = servico.listarTodos();
		this.telaPesquisa();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Opera��o realizada com sucesso!", "Hello "
				+ "Opera��o realizada com sucesso!"));
	}

	public void excluir(Usuario usuario) {
		this.servico.remover(usuario);
		this.lista = servico.listarTodos();
	}

	public void novo() {
		this.entidade = new Usuario();
		this.telaCadastro();
	}

	public void telaCadastro() {
		this.paginaCentralControlador.setPaginaCentral(this.TELA_CADASTRO);
	}

	public void telaPesquisa() {
		this.paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
	}

	public Usuario getEntidade() {
		return entidade;
	}

	public void setEntidade(Usuario entidade) {
		this.entidade = entidade;
	}

	public Usuario getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Usuario pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public UsuarioServico getServico() {
		return servico;
	}

	public void setServico(UsuarioServico servico) {
		this.servico = servico;
	}

	public String logar() {

		Authentication authenticatedUser = this.IEADAMAuthenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(
						this.usuario.getLogin(), this.usuario.getSenha()));

		if (authenticatedUser == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Login e Senha invalido",
							"Login e Senha inv�lidos, tente novamente"));

			this.usuario = new Usuario();

			return "";

		} else {

			this.usuario = (Usuario) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();

			this.colunas = 4;
			// Util .definirTamanhoColuna(usuario.getPerfis().size());

			this.perfilControlador.listaPerfilPorSistemaPorUsuario();

			return "/index.xhtml?faces-redirect=true";
		}
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		this.usuario = new Usuario();
		this.paginaCentralControlador.setPaginaCentral("paginacentral.xhtml");

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		request.getSession().invalidate();

		return "/login.xhtml?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PaginaCentralControlador getpaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setpaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
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

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public SistemaServico getSistemaServico() {
		return sistemaServico;
	}

	public void setSistemaServico(SistemaServico sistemaServico) {
		this.sistemaServico = sistemaServico;
	}

	public PaginaCentralControlador getPaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setPaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	public PerfilControlador getPerfilControlador() {
		return perfilControlador;
	}

	public void setPerfilControlador(PerfilControlador perfilControlador) {
		this.perfilControlador = perfilControlador;
	}
}