package br.com.ss.agile.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.fucapi.bpms.activiti.dominio.Variaveis;

public class VariaveisRequerimento {

	private String descricao;
	private String nome;
	private String fone;
	private String email;
	private String rua;
	private String bairro;
	private String cep;
	private String uf;
	private String cidade;
	private String numeroCNH;
	private String cpf;
	private boolean proprietario;
	private boolean condutor;
	private String marcaModelo;
	private String cor;
	private String ano;
	private String placa;

	private boolean status;
	private String parecer;

	private String protocolo;

	private Date data;

	private String loginGapAnexar;
	private String emailGapAnexar;

	private String loginCariParecer;
	private String emailCariParecer;
	
	private String sistema;
	private Documento documento;
	private List<Documento> documentos;

	/**
	 * Metodo responsavel por converter lista de variaveis (Map) em um objeto
	 * VariaveisProcesso
	 * 
	 * @param variaveis
	 */
	@SuppressWarnings("unchecked")
	@Autowired(required = false)
	public void converterListaVariaveisParaVariaveisProcesso(List<Variaveis> variaveisLista) {
		
		for (Variaveis var : variaveisLista) {
			if (var.getName().equals("nome")) {
				this.setNome(var.getValue().toString());

			} else if (var.getName().equals("fone")) {
				this.setFone(var.getValue().toString());

			} else if (var.getName().equals("email")) {
				this.setEmail(var.getValue().toString());

			} else if (var.getName().equals("rua")) {
				this.setRua(var.getValue().toString());

			} else if (var.getName().equals("bairro")) {
				this.setBairro(var.getValue().toString());

			} else if (var.getName().equals("cep")) {
				this.setCep(var.getValue().toString());

			} else if (var.getName().equals("uf")) {
				this.setUf(var.getValue().toString());

			} else if (var.getName().equals("cidade")) {
				this.setCidade(var.getValue().toString());

			} else if (var.getName().equals("numeroCNH")) {
				this.setNumeroCNH(var.getValue().toString());

			} else if (var.getName().equals("cpf")) {
				this.setCpf(var.getValue().toString());

			} else if (var.getName().equals("proprietario")) {
				this.setProprietario(new Boolean(var.getValue().toString()));

			} else if (var.getName().equals("condutor")) {
				this.setCondutor(new Boolean(var.getValue().toString()));

			} else if (var.getName().equals("marcaModelo")) {
				this.setMarcaModelo(var.getValue().toString());

			} else if (var.getName().equals("cor")) {
				this.setCor(var.getValue().toString());

			} else if (var.getName().equals("placa")) {
				this.setPlaca(var.getValue().toString());
				
			} else if (var.getName().equals("ano")) {
				this.setAno(var.getValue().toString());

			} else if (var.getName().equals("status")) {
				this.setStatus(new Boolean(var.getValue().toString()));

			} else if (var.getName().equals("parecer")) {
				this.setParecer(var.getValue().toString());

			} else if (var.getName().equals("loginGapAnexar")) {
				this.setLoginGapAnexar(var.getValue().toString());

			} else if (var.getName().equals("emailGapAnexar")) {
				this.setEmailGapAnexar(var.getValue().toString());

			} else if (var.getName().equals("loginCariParecer")) {
				this.setLoginCariParecer(var.getValue().toString());

			} else if (var.getName().equals("emailCariParecer")) {
				this.setEmailCariParecer(var.getValue().toString());

			} else if (var.getName().equals("descricao")) {
				this.setDescricao(var.getValue().toString());

			} else if (var.getName().equals("protocolo")) {
				this.setProtocolo(var.getValue().toString());
				
			} else if (var.getName().equals("sistema")) {
				this.setSistema(var.getValue().toString());
			} else if (var.getName().equals("desenhos")) {
				this.documentos = new ArrayList<Documento>();
				
				if (var.getValue() !=null && var.getValue() instanceof List) {
					if (((List<Object>)var.getValue()).iterator().next() instanceof Map) {
						List<Object> objResultado = (List<Object>)var.getValue();
						
						Map<String, Object> mapaDocumento = null;
						for (Object o : objResultado) {
							mapaDocumento = (Map<String, Object>)o;
							this.documento = new Documento();
							this.documento.setTipoDocumento(TipoDocumento.valueOf(mapaDocumento.get("tipoDocumento").toString()));
							this.documento.setUuid(mapaDocumento.get("uuid").toString());
							this.documentos.add(this.documento);
						}
					} else if (((List<Object>)var.getValue()).iterator().next() instanceof Documento) {
						this.documentos = (List<Documento>)var.getValue();
					}
				}
			}
		}
	}

	public Map<String, Object> converterVariaveisProcessoParaMapaVariaveis() {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("nome", this.getNome());
		params.put("fone", this.getFone());
		params.put("email", this.getEmail());
		params.put("rua", this.getRua());
		params.put("bairro", this.getBairro());
		params.put("cep", this.getCep());
		params.put("uf", this.getUf());
		params.put("cidade", this.getCidade());
		params.put("numeroCNH", this.getNumeroCNH());
		params.put("cpf", this.getCpf());
		params.put("proprietario", this.isProprietario());
		params.put("condutor", this.isCondutor());
		params.put("marcaModelo", this.getMarcaModelo());
		params.put("cor", this.getCor());
		params.put("ano", this.getAno());
		params.put("placa", this.getPlaca());
		params.put("status", this.isStatus());
		params.put("parecer", this.getParecer());
		params.put("data", this.getData());
		params.put("protocolo", this.getProtocolo());

		params.put("loginGapAnexar", this.loginGapAnexar);
		params.put("emailGapAnexar", this.emailGapAnexar);
		params.put("loginCariParecer", this.loginCariParecer);
		params.put("emailCariParecer", this.emailCariParecer);
		params.put("descricao", this.descricao);
		
		params.put("sistema", this.sistema);
		params.put("documentos", this.documentos);

		return params;
	}

	public List<Variaveis> converterVariaveisProcessoParaVariaveisActiviti() {
		List<Variaveis> ListaVariaveis = new ArrayList<Variaveis>();

		Variaveis var = new Variaveis();
		var.setName("nome");
		var.setValue(this.getNome());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("fone");
		var.setValue(this.getFone().toString());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("email");
		var.setValue(this.getEmail().toString());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("rua");
		var.setValue(this.getRua());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("bairro");
		var.setValue(this.getBairro());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("cep");
		var.setValue(this.getCep());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("uf");
		var.setValue(this.getUf());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("cidade");
		var.setValue(this.getCidade());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("numeroCNH");
		var.setValue(this.getNumeroCNH());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("cpf");
		var.setValue(this.getCpf());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("proprietario");
		var.setValue(this.isProprietario());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("condutor");
		var.setValue(this.isCondutor());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("marcaModelo");
		var.setValue(this.getMarcaModelo());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("cor");
		var.setValue(this.getCor());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("ano");
		var.setValue(this.getAno());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("placa");
		var.setValue(this.getPlaca());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("parecer");
		var.setValue(this.getParecer());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("protocolo");
		var.setValue(this.getProtocolo());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("data");
		var.setValue(this.getData());
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("loginGapAnexar");
		var.setValue(this.loginGapAnexar);
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("emailGapAnexar");
		var.setValue(this.emailGapAnexar);
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("loginCariParecer");
		var.setValue(this.loginCariParecer);
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("emailCariParecer");
		var.setValue(this.emailCariParecer);
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("descricao");
		var.setValue(this.descricao);
		ListaVariaveis.add(var);
		
		var = new Variaveis();
		var.setName("sistema");
		var.setValue(this.sistema);
		ListaVariaveis.add(var);

		var = new Variaveis();
		var.setName("documentos");
		var.setValue(this.documentos);
		ListaVariaveis.add(var);
		
		return ListaVariaveis;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isProprietario() {
		return proprietario;
	}

	public void setProprietario(boolean proprietario) {
		this.proprietario = proprietario;
	}

	public boolean isCondutor() {
		return condutor;
	}

	public void setCondutor(boolean condutor) {
		this.condutor = condutor;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getLoginGapAnexar() {
		return loginGapAnexar;
	}

	public void setLoginGapAnexar(String loginGapAnexar) {
		this.loginGapAnexar = loginGapAnexar;
	}

	public String getEmailGapAnexar() {
		return emailGapAnexar;
	}

	public void setEmailGapAnexar(String emailGapAnexar) {
		this.emailGapAnexar = emailGapAnexar;
	}

	public String getLoginCariParecer() {
		return loginCariParecer;
	}

	public void setLoginCariParecer(String loginCariParecer) {
		this.loginCariParecer = loginCariParecer;
	}

	public String getEmailCariParecer() {
		return emailCariParecer;
	}

	public void setEmailCariParecer(String emailCariParecer) {
		this.emailCariParecer = emailCariParecer;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

}
