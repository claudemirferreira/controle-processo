package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Usuario;

public interface UsuarioRepositorioJPA {

	List<Usuario> findByUsuario(Usuario usuario);

}