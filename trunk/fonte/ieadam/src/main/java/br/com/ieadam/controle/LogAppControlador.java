package br.com.ieadam.controle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.LogApp;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.servico.LogAppServico;
import br.com.ieadam.servico.UsuarioServico;

@ManagedBean
@SessionScoped
public class LogAppControlador implements Serializable {

	private static final long serialVersionUID = -6832271293709421841L;

	private LogApp pesquisa;

	private List<LogApp> lista;
	
	private List<Usuario> listaUsuarios;
	
	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;
	
	private String TELA_LISTA = "paginas/perfil/lista.xhtml";

	private final String TELA_PESQUISA = "paginas/log/pesquisa.xhtml";

	@ManagedProperty(value = "#{logAppServicoImpl}")
	private LogAppServico servico;
	
	@ManagedProperty(value = "#{usuarioServicoImpl}")
	private UsuarioServico usuarioServico;

	private Date dataInicioPesquisa;
	
	private Date dataFimPesquisa;
	
	public void init() {
		this.lista = servico.listarTodos();
		this.listaUsuarios = usuarioServico.listarTodos();
		telaPesquisa();
	}
	
	public LogAppControlador() {
		this.pesquisa = new LogApp();
	}

	public void pesquisar() {
//		 this.lista = servico.listarPorUsuario(this.pesquisa.getUsuario().getIdUsuario());
		
//		java.sql.Date sqlDataInicio = new java.sql.Date(this.dataInicioPesquisa.getTime());
//		java.sql.Date sqlDataFim = new java.sql.Date(this.dataFimPesquisa.getTime());
		
		this.lista = servico.listarPorFiltros(this.pesquisa.getUsuario().getNome(), 
				this.dataInicioPesquisa, this.dataFimPesquisa);
	}

	public void retornar() {
		this.paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void telaPerfis() {
		this.paginaCentralControlador.setPaginaCentral(this.TELA_LISTA);
	}

	public void listaLogPorUsuario() {
		this.lista = this.servico.listarPorUsuario(this.pesquisa.getUsuario().getIdUsuario());
	}

	public void telaPesquisa() {
		paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
	}

	public PaginaCentralControlador getpaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setpaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	public LogAppServico getServico() {
		return servico;
	}

	public void setServico(LogAppServico servico) {
		this.servico = servico;
	}

	public List<LogApp> getLista() {
		return lista;
	}

	public void setLista(List<LogApp> lista) {
		this.lista = lista;
	}

	public LogApp getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(LogApp pesquisa) {
		this.pesquisa = pesquisa;
	}

	public UsuarioServico getUsuarioServico() {
		return usuarioServico;
	}

	public void setUsuarioServico(UsuarioServico usuarioServico) {
		this.usuarioServico = usuarioServico;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Date getDataInicioPesquisa() {
		return dataInicioPesquisa;
	}

	public void setDataInicioPesquisa(Date dataInicioPesquisa) {
		this.dataInicioPesquisa = dataInicioPesquisa;
	}

	public Date getDataFimPesquisa() {
		return dataFimPesquisa;
	}

	public void setDataFimPesquisa(Date dataFimPesquisa) {
		this.dataFimPesquisa = dataFimPesquisa;
	}
}