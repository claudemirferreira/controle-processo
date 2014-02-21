package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Zona;

public interface NucleoRepositorio extends JpaRepository<Nucleo, Long> {

	@Query("select n from Nucleo n where n.zona = :zona")
	public List<Nucleo> findByZona(@Param("zona") Zona zona);

	@Query("select n from Nucleo n where n.membro = :membro")
	public List<Nucleo> findByMembro(@Param("membro") Membro membro);

}