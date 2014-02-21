package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.UsuarioPerfil;

public interface UsuarioPerfilServico {

	public List<UsuarioPerfil> listarTodos();

	public UsuarioPerfil salvar(UsuarioPerfil usuarioPerfil);

	public void remover(UsuarioPerfil usuarioPerfil);

	public List<Perfil> listaPerfilNotInUsuario(Long idUsuario);

}