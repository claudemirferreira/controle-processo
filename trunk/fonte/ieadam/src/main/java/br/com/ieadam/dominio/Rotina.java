package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the saa_rotina database table.
 * 
 */
@Entity
@Table(name = "saa_rotina")
public class Rotina implements Serializable {

	private static final long serialVersionUID = -8957457180174951533L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 100, nullable = false)
	private String imagem;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 100, nullable = false)
	private String path;

	@Column(length = 1, nullable = false)
	private byte status;

	@OneToMany(mappedBy = "rotina", fetch = FetchType.EAGER)
	private List<PerfilRotina> perfilRotinas;

	@ManyToOne
	@JoinColumn(name = "sistema_id")
	private Sistema sistema;

	public Rotina() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public List<PerfilRotina> getPerfilRotinas() {
		return this.perfilRotinas;
	}

	public void setPerfilRotinas(List<PerfilRotina> perfilRotinas) {
		this.perfilRotinas = perfilRotinas;
	}

	public PerfilRotina addPerfilRotina(PerfilRotina perfilRotina) {
		getPerfilRotinas().add(perfilRotina);
		perfilRotina.setRotina(this);

		return perfilRotina;
	}

	public PerfilRotina removePerfilRotina(PerfilRotina perfilRotina) {
		getPerfilRotinas().remove(perfilRotina);
		perfilRotina.setRotina(null);

		return perfilRotina;
	}

	public Sistema getSistema() {
		return this.sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

}