package br.com.ieadam.servico;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Nucleo;

public interface AreaServico {

	public List<Area> listarTodos();

	public Area salvar(Area area);

	public void remover(Area area);
	
	public List<Area> findByNucleo(Nucleo nucleo);

	public List<Area> findByMembro(Membro membro);
}