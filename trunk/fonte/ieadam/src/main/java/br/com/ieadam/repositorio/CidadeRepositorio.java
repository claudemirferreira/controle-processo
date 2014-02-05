package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ieadam.dominio.Cidade;

public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {

}