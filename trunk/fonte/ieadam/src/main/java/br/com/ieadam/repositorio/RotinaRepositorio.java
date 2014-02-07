package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Rotina;

public interface RotinaRepositorio extends JpaRepository<Rotina, Integer> {

	@Query("select u from Rotina u where u.nome like :nome")
	public List<Rotina> findByNomeLike(@Param("nome") String nome);
}