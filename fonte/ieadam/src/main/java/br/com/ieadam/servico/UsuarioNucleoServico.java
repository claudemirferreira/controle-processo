package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioNucleo;

public interface UsuarioNucleoServico {

	public List<UsuarioNucleo> listarTodos();

	public UsuarioNucleo salvar(UsuarioNucleo usuarioNucleo);

	public void remover(UsuarioNucleo usuarioNucleo);

	public void deleteByUsuarioAndByNucleo(Usuario usuario, Nucleo nucleo);

	public UsuarioNucleo findByUsuarioAndByNucleo(Usuario usuario, Nucleo nucleo);

}