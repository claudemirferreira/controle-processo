package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ieadam.dominio.Membro;

public interface MembroRepositorio extends JpaRepository<Membro, Integer> {

}