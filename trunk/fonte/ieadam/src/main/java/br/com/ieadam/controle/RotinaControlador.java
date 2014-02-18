package br.com.ieadam.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Rotina;
import br.com.ieadam.servico.RotinaServico;

@ManagedBean
@SessionScoped
public class RotinaControlador implements Serializable {

	private static final long serialVersionUID = -6832271293709421841L;

	private Rotina entidade;

	private Rotina pesquisa;

	private Perfil perfil;

	private List<Rotina> lista;

	private int colunas;

	private final String TELA_CADASTRO = "paginas/rotina/cadastro.xhtml";
	private final String TELA_PESQUISA = "paginas/rotina/pesquisa.xhtml";

	private String TELA_LISTA_ROTINAS = "paginas/rotina/lista.xhtml";
	private final String TELA_ROTINA_PERFIL = "paginas/rotina/rotinaperfil.xhtml";

	@ManagedProperty(value = "#{rotinaServicoImpl}")
	private RotinaServico servico;

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	@PostConstruct
	public void init() {
		this.lista = servico.listarTodos();
		this.entidade = new Rotina();
		this.pesquisa = new Rotina();

		this.perfil = new Perfil();

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

	public void telaRotinas(Perfil perfil) {
		this.perfil = perfil;
		this.lista = servico.listaRotinasPorPerfil(perfil.getId());
		this.colunas = 3; // Util.definirTamanhoColuna(rotinas.size());
		
		this.paginaCentralControladorBean
				.setPaginaCentral(this.TELA_LISTA_ROTINAS);

	}
	
	public void teste(){
		
		
		System.out.println("teste###########################");
		
		
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

	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}

	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
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