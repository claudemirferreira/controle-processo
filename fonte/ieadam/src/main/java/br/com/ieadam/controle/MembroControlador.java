package br.com.ieadam.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.enumerated.FatorRH;
import br.com.ieadam.dominio.enumerated.Sexo;
import br.com.ieadam.dominio.enumerated.Situacao;
import br.com.ieadam.servico.CongregacaoServico;
import br.com.ieadam.servico.MembroServico;

@ManagedBean
@SessionScoped
public class MembroControlador implements Serializable {

	private static final long serialVersionUID = -6561146461243717570L;

	private Membro entidade;

	private Membro pesquisa;

	private Congregacao congregacao;

	private List<Congregacao> congregacoes;

	private List<Membro> lista;

	@ManagedProperty(value = "#{membroServicoImpl}")
	private MembroServico servico;

	@ManagedProperty(value = "#{congregacaoServicoImpl}")
	private CongregacaoServico congregacaoServico;

	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;

	private final String TELA_CADASTRO = "paginas/membro/cadastro.xhtml";
	private final String TELA_PESQUISA = "paginas/membro/pesquisa.xhtml";

	public void init() {
		this.lista = servico.listarTodos();
		this.congregacoes = congregacaoServico.listarTodos();

		this.telaPesquisa();

	}

	public MembroControlador() {
		this.entidade = new Membro();
		this.pesquisa = new Membro();
		this.congregacao = new Congregacao();

		this.telaPesquisa();

	}

	public void pesquisar() {

	}

	public void detalhe(Membro membro) {

		this.congregacoes = congregacaoServico.listarTodos();
		this.entidade = membro;
		telaCadastro();

	}

	public void salvar() {

		this.servico.salvar(this.entidade);
		this.lista = servico.listarTodos();
		this.telaPesquisa();
	}

	public void excluir(Membro membro) {
		this.servico.remover(membro);
		this.lista = servico.listarTodos();
	}

	public void novo() {
		this.entidade = new Membro();
		this.congregacao = new Congregacao();

		this.congregacoes = congregacaoServico.listarTodos();
		this.telaCadastro();

	}

	public void telaPesquisa() {
		this.paginaCentralControlador.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void telaCadastro() {
		this.paginaCentralControlador.setPaginaCentral(this.TELA_CADASTRO);
	}

	// get e set
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

	public List<SelectItem> getSexos() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (Sexo c : Sexo.values()) {
			list.add(new SelectItem(c.getId(), c.getDescricao()));
		}
		return list;
	}

	public List<SelectItem> getFatorRHs() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (FatorRH c : FatorRH.values()) {
			list.add(new SelectItem(c.getId(), c.getDescricao()));
		}
		return list;
	}

	public List<SelectItem> getSituacoes() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (Situacao c : Situacao.values()) {
			list.add(new SelectItem(c.getId(), c.getDescricao()));
		}
		return list;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public List<Congregacao> getCongregacoes() {
		return congregacoes;
	}

	public void setCongregacoes(List<Congregacao> congregacoes) {
		this.congregacoes = congregacoes;
	}

	public MembroServico getServico() {
		return servico;
	}

	public void setServico(MembroServico servico) {
		this.servico = servico;
	}

	public CongregacaoServico getCongregacaoServico() {
		return congregacaoServico;
	}

	public void setCongregacaoServico(CongregacaoServico congregacaoServico) {
		this.congregacaoServico = congregacaoServico;
	}

	public PaginaCentralControlador getpaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setpaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

}