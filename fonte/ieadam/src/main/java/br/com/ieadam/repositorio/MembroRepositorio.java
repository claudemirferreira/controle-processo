package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Membro;

public interface MembroRepositorio extends JpaRepository<Membro, Integer> {
	
	@Query("select m from Membro m where m.nome LIKE :nome")
	public List<Membro> listarMembrosPorNomeLike(@Param("nome") String nome);

}