package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.PerfilRotina;

@Repository
public interface PerfilRotinaRepositorio extends
		JpaRepository<PerfilRotina, Integer> {

}
