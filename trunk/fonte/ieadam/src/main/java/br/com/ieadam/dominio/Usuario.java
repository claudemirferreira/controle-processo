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
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "saa_usuario")
public class Usuario extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -3267682267159820805L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(unique = true, length = 30)
	private String login;

	private String senha;

	@Column(name = "status", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String status;
	
	
	@Cascade( value = {org.hibernate.annotations.CascadeType.ALL} )
	@OneToMany( cascade = { CascadeType.ALL}, 
				fetch = FetchType.EAGER, mappedBy = "usuario" )
	private List<UsuarioPerfil> usuarioPerfils;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "membro_id", referencedColumnName = "id", unique = true)
	private Membro membro;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "nivelpastoral_id", referencedColumnName = "id", unique = true)
	private NivelPastoral nivelPastoral;


	
	@Transient
	public UsuarioPerfil getUsuarioPerfilByPerfil( Perfil perfil ) {
		for (UsuarioPerfil up : usuarioPerfils ) {
			if (up.getPerfil().equals(perfil)) { 
				return up;
			}
		}
		return null;
	}
	
	@Transient
	public boolean containsPerfil( Perfil perfil ) {
		return getUsuarioPerfilByPerfil(perfil) != null;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<UsuarioPerfil> getUsuarioPerfils() {
		return usuarioPerfils;
	}

	public void setUsuarioPerfils(List<UsuarioPerfil> usuarioPerfils) {
		this.usuarioPerfils = usuarioPerfils;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}