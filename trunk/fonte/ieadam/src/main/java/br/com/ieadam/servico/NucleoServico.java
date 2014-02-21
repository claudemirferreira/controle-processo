package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Zona;

public interface NucleoServico {

	public List<Nucleo> listarTodos();

	public Nucleo salvar(Nucleo nucleo);

	public void remover(Nucleo nucleo);
	
	public List<Nucleo> findByZona(Zona zona);

	public List<Nucleo> findByMembro(Membro membro);
}