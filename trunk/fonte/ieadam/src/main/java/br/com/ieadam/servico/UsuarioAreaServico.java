package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioArea;

public interface UsuarioAreaServico {

	public List<UsuarioArea> listarTodos();

	public UsuarioArea salvar(UsuarioArea usuarioArea);

	public void remover(UsuarioArea usuarioArea);

	public void deleteByUsuarioAndByArea(Usuario usuario, Area area);

	public UsuarioArea findByUsuarioAndByArea(Usuario usuario, Area area);

}