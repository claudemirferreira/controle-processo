package br.com.ieadam.servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.UsuarioPerfil;

@Repository
public interface UsuarioPerfilRepositorio extends
		JpaRepository<UsuarioPerfil, Integer> {

}