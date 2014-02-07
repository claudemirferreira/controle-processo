package br.com.ieadam.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Rotina;
import br.com.ieadam.servico.RotinaServico;

@ManagedBean
@SessionScoped
public class RotinaControlador implements Serializable {

	private static final long serialVersionUID = -6832271293709421841L;

	private Rotina entidade;

	private Rotina pesquisa;

	private List<Rotina> lista;

	private List<Rotina> moduloSecretaria;

	private List<Rotina> moduloTesouraria;

	private List<Rotina> moduloAdministrativo;

	private int colunas;

	private final String TELA_CADASTRO = "paginas/rotina/cadastro.xhtml";
	private final String TELA_PESQUISA = "paginas/rotina/pesquisa.xhtml";
	private final String TELA_ROTINA_PERFIL = "paginas/rotina/rotinaperfil.xhtml";

	@ManagedProperty(value = "#{rotinaServicoImpl}")
	private RotinaServico servico;

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	@PostConstruct
	public void init() {
		this.moduloSecretaria = Rotina.getModuloSecretaria();
		this.moduloTesouraria = Rotina.getModuloTesouraria();
		this.moduloAdministrativo = Rotina.getModuloAdministrativo();

		this.lista = servico.listarTodos();
		this.entidade = new Rotina();
		this.pesquisa = new Rotina();

	}

	public void pesquisar() {
		this.lista = servico.findByNomeLike(this.pesquisa.getNome());
	}

	public void detalhe(Rotina rotina) {
		this.entidade = rotina;
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_CADASTRO);
	}

	public void salvar() {
		this.servico.salvar(this.entidade);
		this.lista = servico.listarTodos();
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void excluir(Rotina rotina) {
		servico.remover(rotina);
		this.lista = servico.listarTodos();
	}

	public void novo() {
		this.entidade = new Rotina();
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_CADASTRO);
	}

	public void retornar() {
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void telaRelatorio(Rotina rotina) {
		this.paginaCentralControladorBean.setPaginaCentral(rotina.getAcao());
	}

	public Rotina getEntidade() {
		return entidade;
	}

	public void setEntidade(Rotina entidade) {
		this.entidade = entidade;
	}

	public Rotina getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Rotina pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<Rotina> getLista() {
		return lista;
	}

	public void setLista(List<Rotina> lista) {
		this.lista = lista;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public List<Rotina> getModuloSecretaria() {
		return moduloSecretaria;
	}

	public void setModuloSecretaria(List<Rotina> moduloSecretaria) {
		this.moduloSecretaria = moduloSecretaria;
	}

	public List<Rotina> getModuloTesouraria() {
		return moduloTesouraria;
	}

	public void setModuloTesouraria(List<Rotina> moduloTesouraria) {
		this.moduloTesouraria = moduloTesouraria;
	}

	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}

	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
	}

	public List<Rotina> getModuloAdministrativo() {
		return moduloAdministrativo;
	}

	public void setModuloAdministrativo(List<Rotina> moduloAdministrativo) {
		this.moduloAdministrativo = moduloAdministrativo;
	}

	public RotinaServico getServico() {
		return servico;
	}

	public void setServico(RotinaServico servico) {
		this.servico = servico;
	}

	public void telaPesquisa() {
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void telaRotinas(Rotina rotina) {

		this.paginaCentralControladorBean.setPaginaCentral(rotina.getAcao());

	}

}