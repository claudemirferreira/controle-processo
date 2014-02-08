package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Perfil;

public interface PerfilRepositorio extends JpaRepository<Perfil, Integer> {

	@Query("select u from Perfil u where u.nome like :nome")
	public List<Perfil> findByNomeLike(@Param("nome") String nome);

}