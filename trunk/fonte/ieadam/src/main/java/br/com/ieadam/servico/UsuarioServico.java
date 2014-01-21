package br.com.ieadam.servico;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Usuario;

public interface UsuarioServico {

	public List<Usuario> listarTodos();

	public Usuario salvar(Usuario usuario);

	public void remover(Usuario usuario);

	@Query("select u from usuario u where u.login = :login")
	public Usuario findByLogin(@Param("login") String login);

	@Query("select u from usuario u where u.login = :login and u.senha = :senha")
	public Usuario findByLoginAndSenha(@Param("login") String login,
			@Param("senha") String senha) throws NoResultException;
}
