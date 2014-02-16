package br.com.ieadam.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.ieadam.dominio.Cidade;
import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.enumerated.FatorRH;
import br.com.ieadam.dominio.enumerated.Sexo;
import br.com.ieadam.dominio.enumerated.Situacao;
import br.com.ieadam.servico.CidadeServico;
import br.com.ieadam.servico.CongregacaoServico;
import br.com.ieadam.servico.MembroServico;

@ManagedBean
@SessionScoped
public class MembroControlador implements Serializable {

	private static final long serialVersionUID = -6561146461243717570L;

	private Membro entidade;

	private Membro pesquisa;

	private Congregacao congregacao;

	private Cidade cidade;

	private List<Congregacao> congregacoes;

	private List<Cidade> cidades;

	private List<Membro> lista;

	@ManagedProperty(value = "#{membroServicoImpl}")
	private MembroServico servico;

	@ManagedProperty(value = "#{congregacaoServicoImpl}")
	private CongregacaoServico congregacaoServico;

	@ManagedProperty(value = "#{cidadeServicoImpl}")
	private CidadeServico cidadeServico;

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	private final String TELA_CADASTRO = "paginas/membro/cadastro.xhtml";
	private final String TELA_PESQUISA = "paginas/membro/pesquisa.xhtml";

	public void init() {
		this.lista = servico.listarTodos();
		this.congregacoes = congregacaoServico.listarTodos();
		this.cidades = cidadeServico.listarTodos();
		
		this.telaPesquisa();
		
	}
	
	public MembroControlador() {
		this.entidade = new Membro();
		this.pesquisa = new Membro();
		this.congregacao = new Congregacao();
		this.cidade = new Cidade();
		
		this.telaPesquisa();
		
	}

	public void pesquisar() {

	}

	public void detalhe(Membro membro) {

		this.congregacoes = congregacaoServico.listarTodos();
		this.cidades = cidadeServico.listarTodos();

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
		this.cidade = new Cidade();

		this.congregacoes = congregacaoServico.listarTodos();
		this.cidades = cidadeServico.listarTodos();
		this.telaCadastro();

	}

	public void telaPesquisa() {
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void telaCadastro() {
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

	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}

	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public CidadeServico getCidadeServico() {
		return cidadeServico;
	}

	public void setCidadeServico(CidadeServico cidadeServico) {
		this.cidadeServico = cidadeServico;
	}

}