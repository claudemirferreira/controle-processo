package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ieadam.dominio.Perfil;

public interface PerfilRepositorio extends JpaRepository<Perfil, Integer> {

}