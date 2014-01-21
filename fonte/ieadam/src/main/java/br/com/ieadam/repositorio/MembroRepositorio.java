package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Usuario;

public interface MembroRepositorio extends JpaRepository<Membro, Integer> {
	
//	@Query("select u from Membro u where u.us = :login")
//	public Membro findByLogin(@Param("login") String login);

}