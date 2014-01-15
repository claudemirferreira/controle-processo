package br.com.ieadam.repositorio;

import java.util.List;

import javax.persistence.NoResultException;

import br.com.ieadam.dominio.Usuario;

public interface UsuarioRepositorio {
	
	public List<Usuario> list();

	public Usuario autenticarUsuario(String login, String senha) throws NoResultException ;
}