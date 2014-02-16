package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.NivelPastoral;
import br.com.ieadam.dominio.Usuario;

public interface NivelPastoralRepositorio extends JpaRepository<NivelPastoral, Integer> {
	
	@Query("select m from NivelPastoral m where m.usuario = :usuario")
	public NivelPastoral findByUsuario(@Param("usuario") Usuario usuario);
	
}