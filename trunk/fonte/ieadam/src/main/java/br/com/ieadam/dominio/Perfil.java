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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ieadam_perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = -5594956718599379597L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(length = 100, nullable = false)
	private String descricao;

	@Column(length = 100, nullable = false)
	private String imagem;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "perfil_id", referencedColumnName = "id"))
	private List<Usuario> usuarios;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "perfil_rotina", joinColumns = @JoinColumn(name = "rotina_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "perfil_id", referencedColumnName = "id"))
	private List<Rotina> rotinas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Rotina> getRotinas() {
		return rotinas;
	}

	public void setRotinas(List<Rotina> rotinas) {
		this.rotinas = rotinas;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}