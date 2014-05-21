package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;

public interface NucleoServico {

	public List<Nucleo> listarTodos();

	public Nucleo salvar(Nucleo nucleo);

	public void remover(Nucleo nucleo);
	
	public List<Nucleo> findByZona(int zona);

	public List<Nucleo> findByMembro(int membro);
	
	public Nucleo findOne(int id);
	
	public List<Nucleo> listaNucleoUsuario(Usuario usuario);
	
	public List<Nucleo> listaNucleoToUsuarioAndZona(Usuario usuario, Zona zona);
	
	public boolean isUsuarioDeNucleo(int usuarioId, int idNucleo);
}