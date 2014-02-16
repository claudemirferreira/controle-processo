package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "saa_usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -3267682267159820805L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true, length = 30)
	private String login;

	private String senha;

	@Column(name = "situacao", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String situacao;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<UsuarioPerfil> perfilRotinas;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "membro_id", referencedColumnName = "id", unique = true)
	private Membro membro;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "nivelpastoral_id", referencedColumnName = "id", unique = true)
	private NivelPastoral nivelPastoral;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public NivelPastoral getNivelPastoral() {
		return nivelPastoral;
	}

	public void setNivelPastoral(NivelPastoral nivelPastoral) {
		this.nivelPastoral = nivelPastoral;
	}

	public List<UsuarioPerfil> getPerfilRotinas() {
		return perfilRotinas;
	}

	public void setPerfilRotinas(List<UsuarioPerfil> perfilRotinas) {
		this.perfilRotinas = perfilRotinas;
	}

}