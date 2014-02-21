package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Nucleo;

public interface AreaRepositorio extends JpaRepository<Area, Long> {

	@Query("select a from Area a where a.nucleo = :nucleo")
	public List<Area> findByNucleo(@Param("nucleo") Nucleo nucleo);

	@Query("select a from Area a where a.membro = :membro")
	public List<Area> findByMembro(@Param("membro") Membro membro);
}