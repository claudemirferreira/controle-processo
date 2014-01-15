package br.com.ieadam.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicoImpl implements UsuarioServico {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public Usuario autenticarUsuario(String login, String senha) {
		return usuarioRepositorio.autenticarUsuario(login, senha);
	}
}
