package br.com.ieadam.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.componentes.Util;
import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Rotina;
import br.com.ieadam.servico.PerfilServico;
import br.com.ieadam.servico.RotinaServico;

@ManagedBean
@SessionScoped
public class PerfilControlador implements Serializable {

	private static final long serialVersionUID = -6832271293709421841L;

	private Perfil perfil;

	private List<Rotina> rotinas;

	private Perfil entidade;

	private Perfil pesquisa;

	private List<Perfil> lista;

	private int colunas;

	private String TELA_LISTA_ROTINAS = "paginas/rotina/lista.xhtml";

	private String TELA_LISTA_PEFIS = "paginas/perfil/lista.xhtml";
	
	private final String TELA_CADASTRO = "paginas/perfil/cadastro.xhtml";
	
	private final String TELA_PESQUISA = "paginas/perfil/pesquisa.xhtml";

	@ManagedProperty(value = "#{perfilServicoImpl}")
	private PerfilServico servico;

	@ManagedProperty(value = "#{rotinaServicoImpl}")
	private RotinaServico rotinaServico;

	@ManagedProperty(value = "#{paginaCentralControladorBean}")
	private PaginaCentralControladorBean paginaCentralControladorBean;

	@PostConstruct
	public void init() {

		this.lista = servico.listarTodos();
		this.entidade = new Perfil();
		this.pesquisa = new Perfil();
	}
	
	public void pesquisar() {
//		this.lista = servico.findBySistemaByNomeLike(this.sistema,this.pesquisa.getNome());
	}

	public void detalhe(Perfil perfil) {
		this.entidade = perfil;
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_CADASTRO);
	}

	public void salvar() {
		this.servico.salvar(this.entidade);
		this.lista = servico.listarTodos();
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void excluir(Perfil perfil) {
		servico.remover(perfil);
		this.lista = servico.listarTodos();
	}

	public void novo() {
		this.entidade = new Perfil();
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_CADASTRO);

	}

	public void retornar() {
		this.paginaCentralControladorBean.setPaginaCentral(this.TELA_PESQUISA);
	}

	public void telaRotinas(Perfil perfil) {
		this.perfil = perfil;
		this.rotinas = rotinaServico.listaRotinasPorPerfil(perfil.getId());
		this.colunas = Util.definirTamanhoColuna(rotinas.size());
		this.paginaCentralControladorBean
				.setPaginaCentral(this.TELA_LISTA_ROTINAS);

	}

	public void telaPerfis() {
		this.paginaCentralControladorBean
				.setPaginaCentral(this.TELA_LISTA_PEFIS);
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public PaginaCentralControladorBean getPaginaCentralControladorBean() {
		return paginaCentralControladorBean;
	}

	public void setPaginaCentralControladorBean(
			PaginaCentralControladorBean paginaCentralControladorBean) {
		this.paginaCentralControladorBean = paginaCentralControladorBean;
	}

	public PerfilServico getServico() {
		return servico;
	}

	public void setServico(PerfilServico servico) {
		this.servico = servico;
	}

	public RotinaServico getRotinaServico() {
		return rotinaServico;
	}

	public void setRotinaServico(RotinaServico rotinaServico) {
		this.rotinaServico = rotinaServico;
	}

	public List<Rotina> getRotinas() {
		return rotinas;
	}

	public void setRotinas(List<Rotina> rotinas) {
		this.rotinas = rotinas;
	}

	public List<Perfil> getLista() {
		return lista;
	}

	public void setLista(List<Perfil> lista) {
		this.lista = lista;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public Perfil getEntidade() {
		return entidade;
	}

	public void setEntidade(Perfil entidade) {
		this.entidade = entidade;
	}

	public Perfil getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Perfil pesquisa) {
		this.pesquisa = pesquisa;
	}

}