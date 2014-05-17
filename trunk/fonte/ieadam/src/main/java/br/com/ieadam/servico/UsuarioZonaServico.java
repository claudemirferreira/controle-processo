package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioZona;
import br.com.ieadam.dominio.Zona;

public interface UsuarioZonaServico {

	public List<UsuarioZona> listarTodos();

	public UsuarioZona salvar(UsuarioZona usuarioZona);

	public void remover(UsuarioZona usuarioZona);

	public void deleteByUsuarioAndByZona(Usuario usuario, Zona zona);

	public UsuarioZona findByUsuarioAndByZona(Usuario usuario, Zona zona);

	public List<Zona> findByUsuario(Usuario usuario);
}