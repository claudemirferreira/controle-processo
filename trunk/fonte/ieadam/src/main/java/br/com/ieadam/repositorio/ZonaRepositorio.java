package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ieadam.dominio.Zona;

public interface ZonaRepositorio extends JpaRepository<Zona, Integer> {

}