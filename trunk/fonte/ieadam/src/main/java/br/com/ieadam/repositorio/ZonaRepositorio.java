package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Zona;

public interface ZonaRepositorio extends JpaRepository<Zona, Long> {

	@Query("select z from Zona z where z.primeiroResponsavel = :membro or z.segundoResponsavel =:membro")
	public List<Zona> findByMembro(@Param("membro") Membro membro);

}