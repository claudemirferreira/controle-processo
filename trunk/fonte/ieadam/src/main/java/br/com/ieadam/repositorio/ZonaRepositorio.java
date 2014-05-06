package br.com.ieadam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Zona;

public interface ZonaRepositorio extends JpaRepository<Zona, Long> {

	@Query("select z from Zona z where z.idPrimeiroResp = :membro or z.idSegundoResp =:membro")
	public List<Zona> findByMembro(@Param("membro") int membro);
	
	@Query("select z from Zona z where z.idZona = :id")
	public Zona findOne(@Param("id") int id);
	
	@Query("select z from Zona z where z.situacao = :situacao")
	public List<Zona> findAllBySituacao(@Param("situacao") String situacao);
}