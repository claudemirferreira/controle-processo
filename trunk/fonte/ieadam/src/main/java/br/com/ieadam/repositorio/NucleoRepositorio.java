package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ieadam.dominio.Nucleo;

public interface NucleoRepositorio extends JpaRepository<Nucleo, Integer> {

}