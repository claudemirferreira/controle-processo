package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author altitdb
 */
@Entity
@Table(name = "saa_usuario")
public class Usuario extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -7789936704890560797L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUsuario;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE,
			CascadeType.REMOVE }, mappedBy = "usuarioPerfilPk.usuario")
	private List<UsuarioPerfil> usuarioPerfil = new ArrayList<UsuarioPerfil>();

	@Column(unique = true, length = 30)
	private String login;

	private String senha;

	@Column(name = "status", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String status;

	private boolean zona;

	private boolean area;

	private boolean nucleo;

//	@OneToOne
//	@JoinColumn(name = "id_membro")
//	private Membro membro;
	
	@Column
	private int idMembro;

	@Override
	public int getId() {
		return idUsuario;
	}

	@Transient
	public UsuarioPerfil getUsuarioPerfilByPerfil(Perfil perfil) {
		for (UsuarioPerfil up : usuarioPerfil) {
			if (up.getUsuarioPerfilPk().getPerfil().equals(perfil)) {
				return up;
			}
		}
		return null;
	}

	@Transient
	public boolean containsPerfil(Perfil perfil) {
		return getUsuarioPerfilByPerfil(perfil) != null;
	}

	public List<UsuarioPerfil> getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(List<UsuarioPerfil> usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isZona() {
		return zona;
	}

	public void setZona(boolean zona) {
		this.zona = zona;
	}

	public boolean isArea() {
		return area;
	}

	public void setArea(boolean area) {
		this.area = area;
	}

	public boolean isNucleo() {
		return nucleo;
	}

	public void setNucleo(boolean nucleo) {
		this.nucleo = nucleo;
	}

	public int getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(int idMembro) {
		this.idMembro = idMembro;
	}

//	public Membro getMembro() {
//		return membro;
//	}
//
//	public void setMembro(Membro membro) {
//		this.membro = membro;
//	}
}