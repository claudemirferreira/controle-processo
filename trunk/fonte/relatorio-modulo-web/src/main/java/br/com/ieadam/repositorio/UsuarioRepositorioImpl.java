package br.com.ieadam.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ieadam.dominio.Usuario;

@Repository
@Transactional
public class UsuarioRepositorioImpl  implements Serializable, UsuarioRepositorio {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager entityManager;

	
	public void save(Usuario usuario) {
		entityManager.persist(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		return entityManager.createQuery("select u from tbl_usuario u")
				.getResultList();
	}

	public Usuario autenticarUsuario(String login, String senha) throws NoResultException {
		Query query = entityManager.createQuery("from Usuario u where u.login = :login and u.senha=:senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);

		return (Usuario) query.getSingleResult();
	}
	

	public void flush() {
		entityManager.flush();
	}

	public void flush(boolean flush) {
		if (flush) {
			flush();
		}
	}
}