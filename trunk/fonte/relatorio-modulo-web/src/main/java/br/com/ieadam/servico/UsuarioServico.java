package br.com.ieadam.servico;

import br.com.ieadam.dominio.Usuario;

public interface UsuarioServico {

	Usuario autenticarUsuario(String login, String senha);
}
