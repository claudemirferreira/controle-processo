package br.com.ieadam.repositorio;

import javax.persistence.NoResultException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	@Query("select u from Usuario u where u.login = :login")
	public Usuario findByLogin(@Param("login") String login);

	@Query("select u from Usuario u where u.login = :login and u.senha = :senha")
	public Usuario findByLoginAndSenha(@Param("login") String login,
		@Param("senha") String senha) throws NoResultException;

}