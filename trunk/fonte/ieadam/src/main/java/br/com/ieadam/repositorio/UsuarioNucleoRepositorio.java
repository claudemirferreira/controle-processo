package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioNucleo;

public interface UsuarioNucleoRepositorio extends
		JpaRepository<UsuarioNucleo, Long> {

	@Query("select a from UsuarioNucleo a where a.usuario = :usuario and  a.nucleo = :nucleo order by a.nucleo.nome")
	public UsuarioNucleo findByUsuarioAndByNucleo(
			@Param("usuario") Usuario usuario, @Param("nucleo") Nucleo nucleo);

	@Modifying
	@Transactional
	@Query("delete from UsuarioNucleo a where a.usuario = :usuario and  a.nucleo = :nucleo")
	void deleteByUsuarioAndByNucleo(@Param("usuario") Usuario usuario,
			@Param("nucleo") Nucleo nucleo);
}