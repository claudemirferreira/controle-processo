package br.com.ieadam.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.servico.MembroServico;

@ManagedBean
@SessionScoped
public class MembroControlador {

	private Membro entidade;

	private Membro pesquisa;

	private List<Membro> lista;

	private List<Perfil> perfis = new ArrayList<Perfil>();

	@ManagedProperty(value = "#{membroServicoImpl}")
	private MembroServico servico;

	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;
	
	private final String TELA_PESQUISA = "paginas/membro/pesquisa.xhtml";
	
	public void init() {
		this.lista = servico.listarTodos();
		this.telaPesquisa();
	}

	public MembroControlador() {
		this.entidade = new Membro();
		this.pesquisa = new Membro();
	}

	public void pesquisar() {
//		this.lista = this.servico.findByMembro(this.pesquisa);
	}

	public void excluir(Membro Membro) {
		this.servico.remover(Membro);
		this.lista = servico.listarTodos();
	}

	public String telaPesquisa() {
		this.pesquisa = new Membro();
		this.paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
		return "index.xhtml?faces-redirect=true";
	}

	public Membro getEntidade() {
		return entidade;
	}

	public void setEntidade(Membro entidade) {
		this.entidade = entidade;
	}

	public Membro getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Membro pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<Membro> getLista() {
		return lista;
	}

	public void setLista(List<Membro> lista) {
		this.lista = lista;
	}

	public MembroServico getServico() {
		return servico;
	}

	public void setServico(MembroServico servico) {
		this.servico = servico;
	}

	public PaginaCentralControlador getpaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setpaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public PaginaCentralControlador getPaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setPaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}
}