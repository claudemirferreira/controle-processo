package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Area;

public interface AreaRepositorio extends JpaRepository<Area, Long> {

	@Query("select a from Area a where a.idNucleo = :nucleo")
	public List<Area> findByNucleo(@Param("nucleo") int nucleo);

	@Query("select a from Area a where a.idPastor = :membro")
	public List<Area> findByMembro(@Param("membro") int membro);
}