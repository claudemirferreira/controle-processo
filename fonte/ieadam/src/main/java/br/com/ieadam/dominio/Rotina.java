package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ieadam_rotina")
public class Rotina implements Serializable {

	private static final long serialVersionUID = 8724103892548378330L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(length = 100, nullable = false)
	private String descricao;

	@Column(length = 100, nullable = false)
	private String acao;

	@Column(length = 100, nullable = false)
	private String imagem;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "perfil_rotina", joinColumns = @JoinColumn(name = "rotina_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "perfil_id", referencedColumnName = "id"))
	private List<Perfil> perfis;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Rotina( String nome, String descricao, String acao, String imagem) {
		this.nome = nome;
		this.descricao = descricao;
		this.acao = acao;
		this.imagem = imagem;
	}
	
	public Rotina(int id, String nome, String descricao, String acao, String imagem) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.acao = acao;
		this.imagem = imagem;
	}

	public Rotina() {
	}

	public static List<Rotina> getModuloTesouraria() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("SALDO DA CONGREGAÇÃO", "DESCRICAO",
				"paginas/relatorio/tesouraria/saldocongregacao.xhtml",
				"resources/imagens/rotina/banknote.png");
		list.add(rotina);

		rotina = new Rotina("PROVENTO PASTORAL", "DESCRICAO",
				"paginas/relatorio/tesouraria/proventopastoral.xhtml",
				"resources/imagens/rotina/bar_chart.png");
		list.add(rotina);

		rotina = new Rotina("DÉBITO FINANCEIRO", "DESCRICAO",
				"paginas/relatorio/tesouraria/debitofinanceiro.xhtml",
				"resources/imagens/rotina/calculator.png");
		list.add(rotina);

		rotina = new Rotina("CENTRO DE CUSTO", "DESCRICAO",
				"paginas/relatorio/tesouraria/centrocusto.xhtml",
				"resources/imagens/rotina/cash_register.png");
		list.add(rotina);

		rotina = new Rotina("NADA CONSTA", "DESCRICAO",
				"paginas/relatorio/tesouraria/nadaconsta.xhtml",
				"resources/imagens/rotina/coins.png");
		list.add(rotina);

		rotina = new Rotina("SALDO DEPARTAMENTAL", "DESCRICAO",
				"paginas/relatorio/tesouraria/saldodepartamental.xhtml",
				"resources/imagens/rotina/credit_card.png");
		list.add(rotina);

		rotina = new Rotina("BALANCETE ANALITICO", "DESCRICAO",
				"paginas/relatorio/tesouraria/saldocongregacao.xhtml",
				"resources/imagens/rotina/gold_bullion.png");
		list.add(rotina);

		rotina = new Rotina("BALANCETE SINTÉTICO", "DESCRICAO",
				"paginas/relatorio/tesouraria/saldocongregacao.xhtml",
				"resources/imagens/rotina/invoice.png");
		list.add(rotina);

		return list;
	}

	public static List<Rotina> getModuloSecretaria() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("debitoSecretaria1", "DESCRICAO",
				"debitoSecretaria.show()",
				"resources/imagens/rotina/banknote.png");
		list.add(rotina);

		rotina = new Rotina("estatistico1", "DESCRICAO", "estatistico",
				"resources/imagens/rotina/bar_chart.png");
		list.add(rotina);

		rotina = new Rotina("MEMBROS", "DESCRICAO", "ACAO",
				"resources/imagens/rotina/calculator.png");
		list.add(rotina);

		rotina = new Rotina("DÉBITO PASTORAL", "DESCRICAO", "ACAO",
				"resources/imagens/rotina/cash_register.png");
		list.add(rotina);

		return list;
	}

	public static List<Rotina> getModuloAdministrativo() {

		List<Rotina> list = new ArrayList<Rotina>();
		Rotina rotina = new Rotina("CADASTRO DE MEMBRO", "DESCRICAO",
				"paginas/membro/pesquisa.xhtml",
				"resources/imagens/rotina/banknote.png");
		list.add(rotina);

		rotina = new Rotina("PROVENTO PASTORAL", "DESCRICAO",
				"paginas/relatorio/tesouraria/proventopastoral.xhtml",
				"resources/imagens/rotina/bar_chart.png");
		list.add(rotina);

		return list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

}
