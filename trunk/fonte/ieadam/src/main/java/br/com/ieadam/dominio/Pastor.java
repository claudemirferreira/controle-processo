package br.com.ieadam.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ieadam_pastor")
public class Pastor extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 7025896792570044669L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPastor;

	@Column(nullable = false, length = 60)
	private String nome;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "id_membro")
	private Membro membro;

	@Override
	public Long getId() {
		return idPastor;
	}
	
	public Long getIdPastor() {
		return idPastor;
	}

	public void setIdPastor(Long idPastor) {
		this.idPastor = idPastor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

}