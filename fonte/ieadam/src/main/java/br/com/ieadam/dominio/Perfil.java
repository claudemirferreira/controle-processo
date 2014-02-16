package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the _perfil database table.
 * 
 */
@Entity
@Table(name = "saa_perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = -729781000696371926L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 30, nullable = false)
	private String nome;

	@Column(length = 60, nullable = false)
	private String imagem;

	@ManyToOne
	@JoinColumn(name = "sistema_id")
	private Sistema sistema;

	@OneToMany(mappedBy = "perfil")
	private List<PerfilRotina> perfilRotinas;

	@OneToMany(mappedBy = "perfil")
	private List<UsuarioPerfil> usuarioPerfis;

	@Transient
	private boolean checked;
	
	
	public Perfil() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Sistema getSistema() {
		return this.sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public List<PerfilRotina> getPerfilRotinas() {
		return this.perfilRotinas;
	}

	public void setPerfilRotinas(List<PerfilRotina> perfilRotinas) {
		this.perfilRotinas = perfilRotinas;
	}

	public List<UsuarioPerfil> getUsuarioPerfis() {
		return usuarioPerfis;
	}

	public PerfilRotina addPerfilRotina(PerfilRotina perfilRotina) {
		getPerfilRotinas().add(perfilRotina);
		perfilRotina.setPerfil(this);

		return perfilRotina;
	}

	public PerfilRotina removePerfilRotina(PerfilRotina perfilRotina) {
		getPerfilRotinas().remove(perfilRotina);
		perfilRotina.setPerfil(null);

		return perfilRotina;
	}

	public void setUsuarioPerfis(List<UsuarioPerfil> usuarioPerfis) {
		this.usuarioPerfis = usuarioPerfis;
	}

	public UsuarioPerfil addUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		getUsuarioPerfis().add(usuarioPerfil);
		usuarioPerfil.setPerfil(this);

		return usuarioPerfil;
	}

	public UsuarioPerfil removeUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		getUsuarioPerfis().remove(usuarioPerfil);
		usuarioPerfil.setPerfil(null);

		return usuarioPerfil;
	}
	

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}