package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ieadam.dominio.Congregacao;

public interface CongregacaoRepositorio extends
		JpaRepository<Congregacao, Integer> {

}