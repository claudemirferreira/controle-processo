package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioPerfil;

@Repository
public interface UsuarioPerfilRepositorio extends
		JpaRepository<UsuarioPerfil, Long> {
	

//	@Query("select up from UsuarioPerfil up " +
//			" where up.usuario = :usuario " +
//			" and up NOT IN ( " +
//				" select up2 from UsuarioPerfil up2 " + 
//				" where up2 = up " +
//			" ) ")
//	public List<UsuarioPerfil> listaPerfisDiferentesUsuario(/*@Param("usuario")*/ Usuario usuario);

}