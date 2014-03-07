package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioPerfil;

@Repository
public interface UsuarioPerfilRepositorio extends
		JpaRepository<UsuarioPerfil, Long> {

	@Query("select up from UsuarioPerfil up "
			+ " where up.usuarioPerfilPk.usuario = :usuario "
			+ " and up.usuarioPerfilPk.perfil = :perfil ")
	public UsuarioPerfil findByUsuarioAndPerfil(
			@Param("usuario") Usuario usuario, @Param("perfil") Perfil perfil);

	@Query("select up from UsuarioPerfil up "
			+ " where up.usuarioPerfilPk.usuario = :usuario ")
	public List<UsuarioPerfil> findByUsuario(@Param("usuario") Usuario usuario);

}