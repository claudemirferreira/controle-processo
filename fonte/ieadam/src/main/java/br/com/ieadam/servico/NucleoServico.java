package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;

public interface NucleoServico {

	public List<Nucleo> listarTodos();

	public Nucleo salvar(Nucleo nucleo);

	public void remover(Nucleo nucleo);
	
	public List<Nucleo> findByZona(int zona);

	public List<Nucleo> findByMembro(int membro);
	
	public Nucleo findOne(int id);
	
	public List<Nucleo> listaNucleoUsuario(Usuario usuario);
}