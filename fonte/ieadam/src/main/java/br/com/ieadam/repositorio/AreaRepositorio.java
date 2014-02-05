package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ieadam.dominio.Area;

public interface AreaRepositorio extends JpaRepository<Area, Integer> {

}