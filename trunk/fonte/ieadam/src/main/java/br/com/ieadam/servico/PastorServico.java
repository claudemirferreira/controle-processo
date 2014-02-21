package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Pastor;
import br.com.ieadam.dominio.Usuario;

public interface PastorServico {

	public List<Pastor> listarTodos();

	public Pastor salvar(Pastor pastor);

	public void remover(Pastor pastor);

	public Pastor findByUsuario(Usuario usuario);

}