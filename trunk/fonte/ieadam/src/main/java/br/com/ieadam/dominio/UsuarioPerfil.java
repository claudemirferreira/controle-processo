package br.com.ieadam.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * 
 * @author altitdb
 */
@Entity
//@AssociationOverrides({
//		@AssociationOverride(name = "usuarioPerfilPk.usuario", joinColumns = @JoinColumn(name = "id_usuario")),
//		@AssociationOverride(name = "usuarioPerfilPk.perfil", joinColumns = @JoinColumn(name = "id_perfil")) })
@Table( name = "saa_usuario_perfil", 
	uniqueConstraints = @UniqueConstraint( columnNames = { "id_usuario", "id_perfil", "data"} ) )
public class UsuarioPerfil implements Serializable {

	private static final long serialVersionUID = -1220797610390530939L;

//	@EmbeddedId
//	private UsuarioPerfilPk usuarioPerfilPk = new UsuarioPerfilPk();
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "id_usuario_perfil", unique = true, nullable = false )
    private Long idUsuarioPerfil;

    public Long getIdUsuarioPerfil() {
		return idUsuarioPerfil;
	}

	public void setIdUsuarioPerfil(Long idUsuarioPerfil) {
		this.idUsuarioPerfil = idUsuarioPerfil;
	}

	@ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_perfil", nullable = false )
    private Perfil perfil;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_usuario", nullable = false )
    private Usuario usuario;
    

	@Temporal(TemporalType.TIMESTAMP)	// TODO notnull
	private Date data;


    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil( Perfil perfil ) {
        this.perfil = perfil;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario( Usuario usuario ) {
        this.usuario = usuario;
    }

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}