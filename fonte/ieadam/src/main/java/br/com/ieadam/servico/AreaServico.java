package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Area;

public interface AreaServico {

	public List<Area> listarTodos();

	public Area salvar(Area area);

	public void remover(Area area);
	
	public List<Area> findByNucleo(int nucleo);

	public List<Area> findByMembro(int membro);
}