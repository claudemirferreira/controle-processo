package br.com.ieadam.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ieadam_membro")
public class Membro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@OneToOne
	private Funcao funcao;

	@ManyToOne
	private Congregacao congregacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@Temporal(TemporalType.DATE)
	private Date dataDecisao;
	
	@Temporal(TemporalType.DATE)
	private Date dataRecebimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataBatismo;

	@Temporal(TemporalType.DATE)
	private Date dataBatEspirito;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	private String nome;
	private String Sexo;
	private String cidade;
	private String uf;
	private String nacionalidade;
	private String estadoCivil;
	private String rg;
	private String cpf;
	private String rgOrgaoEmissor;
	private String email;
	private String tituloEleitor;
	private String nomePai;
	private String tituloZona;
	private String nomeMae;
	private String tituloSecao;
	private String conjuge;
	private int qtdeFilhos;
	private String fatorRh;
	private String endereco;
	private String cep;
	private String telefone;
	private String certCasamento;
	private String procedencia;
	private String formacaoTeologico;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	public Congregacao getCongregacao() {
		return congregacao;
	}
	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataDecisao() {
		return dataDecisao;
	}
	public void setDataDecisao(Date dataDecisao) {
		this.dataDecisao = dataDecisao;
	}
	public Date getDataRecebimento() {
		return dataRecebimento;
	}
	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
	public Date getDataBatismo() {
		return dataBatismo;
	}
	public void setDataBatismo(Date dataBatismo) {
		this.dataBatismo = dataBatismo;
	}
	public Date getDataBatEspirito() {
		return dataBatEspirito;
	}
	public void setDataBatEspirito(Date dataBatEspirito) {
		this.dataBatEspirito = dataBatEspirito;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRgOrgaoEmissor() {
		return rgOrgaoEmissor;
	}
	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		this.rgOrgaoEmissor = rgOrgaoEmissor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTituloEleitor() {
		return tituloEleitor;
	}
	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getTituloZona() {
		return tituloZona;
	}
	public void setTituloZona(String tituloZona) {
		this.tituloZona = tituloZona;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getTituloSecao() {
		return tituloSecao;
	}
	public void setTituloSecao(String tituloSecao) {
		this.tituloSecao = tituloSecao;
	}
	public String getConjuge() {
		return conjuge;
	}
	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}
	public int getQtdeFilhos() {
		return qtdeFilhos;
	}
	public void setQtdeFilhos(int qtdeFilhos) {
		this.qtdeFilhos = qtdeFilhos;
	}
	public String getFatorRh() {
		return fatorRh;
	}
	public void setFatorRh(String fatorRh) {
		this.fatorRh = fatorRh;
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
	public String getCertCasamento() {
		return certCasamento;
	}
	public void setCertCasamento(String certCasamento) {
		this.certCasamento = certCasamento;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	public String getFormacaoTeologico() {
		return formacaoTeologico;
	}
	public void setFormacaoTeologico(String formacaoTeologico) {
		this.formacaoTeologico = formacaoTeologico;
	}
}
