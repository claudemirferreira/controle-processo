package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioZona;
import br.com.ieadam.dominio.Zona;

public interface UsuarioZonaRepositorio extends
		JpaRepository<UsuarioZona, Long> {

	@Query("select a from UsuarioZona a where a.usuario = :usuario and  a.zona = :zona order by a.zona.nome")
	public UsuarioZona findByUsuarioAndByZona(
			@Param("usuario") Usuario usuario, @Param("zona") Zona zona);

	@Modifying
	@Transactional
	@Query("delete from UsuarioZona a where a.usuario = :usuario and  a.zona = :zona")
	void deleteByUsuarioAndByZona(@Param("usuario") Usuario usuario,
			@Param("zona") Zona zona);
	
	@Query("select a from UsuarioZona a where a.usuario = :usuario")
	List<UsuarioZona> findByUsuario(@Param("usuario") Usuario usuario);
	
}