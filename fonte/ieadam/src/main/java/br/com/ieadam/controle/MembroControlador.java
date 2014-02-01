package br.com.ieadam.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Situacao;
import br.com.ieadam.servico.CongregacaoServico;
import br.com.ieadam.servico.MembroServico;

@ManagedBean
@SessionScoped
public class MembroControlador implements Serializable {

	private static final long serialVersionUID = -6561146461243717570L;

	private Membro entidade;

	private Membro pesquisa;

	private List<Congregacao> congregacoes;

	private List<Membro> lista;

	private Situacao[] situacoes;

	@ManagedProperty(value = "#{membroServicoImpl}")
	private MembroServico servico;

	@ManagedProperty(value = "#{congregacaoServicoImpl}")
	private CongregacaoServico congregacaoServico;

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	private final String TELA_CADASTRO = "paginas/membro/cadastro.xhtml";
	private final String TELA_PESQUISA = "paginas/membro/pesquisa.xhtml";

	@PostConstruct
	public void init() {
		this.lista = servico.listarTodos();
		this.entidade = new Membro();
		this.pesquisa = new Membro();
	}

	public void pesquisar() {

	}

	public void detalhe(Membro membro) {

		this.entidade = membro;
		this.congregacoes = congregacaoServico.listarTodos();
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_CADASTRO);

	}

	public void salvar() {

		servico.salvar(this.entidade);
		this.lista = servico.listarTodos();
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void excluir(Membro membro) {
		servico.remover(membro);
		this.lista = servico.listarTodos();
	}

	public void novo() {

		this.entidade = new Membro();
//		this.congregacoes = congregacaoServico.listarTodos();
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_CADASTRO);

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

	public Situacao[] getSituacoes() {
		return Situacao.values();
	}

	public void setSituacoes(Situacao[] situacoes) {
		this.situacoes = situacoes;
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

	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}

	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
	}

}