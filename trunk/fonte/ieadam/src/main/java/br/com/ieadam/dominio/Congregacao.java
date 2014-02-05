package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ieadam.dominio.enumerated.Situacao;

@Entity
@Table(name = "ieadam_congregacao")
public class Congregacao implements Serializable {

	private static final long serialVersionUID = 7686113032375136921L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToMany
	@JoinColumn(name = "congregacao_id", referencedColumnName = "id")
	private Set<Membro> membros;

	@ManyToOne
	@JoinColumn(name = "cidade_id", referencedColumnName = "id", unique = true)
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "area_id", referencedColumnName = "id", unique = true)
	private Area area;

	@Column(length = 60, nullable = false)
	private String bairro;

	@Temporal(TemporalType.DATE)
	private Date dataFundacao;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(length = 60, nullable = false)
	private String endereco;

	@Column(length = 8)
	private String cep;

	@Column(length = 30)
	private String telefone;

	@Enumerated
	@Column(name = "situacao", nullable = false, length = 1)
	private Situacao situacao;

	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Membro> getMembros() {
		return membros;
	}

	public void setMembro(Set<Membro> membros) {
		this.membros = membros;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setMembros(Set<Membro> membros) {
		this.membros = membros;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}