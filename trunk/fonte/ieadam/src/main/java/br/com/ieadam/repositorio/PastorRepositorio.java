package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Pastor;
import br.com.ieadam.dominio.Usuario;

public interface PastorRepositorio extends JpaRepository<Pastor, Long> {
	
	@Query("select u from Pastor u where u.usuario = :usuario")
	public Pastor findByUsuario(@Param("usuario") Usuario usuario);

}