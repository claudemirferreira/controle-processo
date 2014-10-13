package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;

public interface AreaServico {

	public List<Area> listarTodos();

	public Area salvar(Area area);

	public void remover(Area area);
	
	public List<Area> findByNucleo(int nucleo);

	public List<Area> findByMembro(int membro);
	
	public List<Area> findByMembroAndNucleo(int membro, int idNucleo);
	
	public List<Area> listaAreaToUsuarioAndNucleo(Usuario usuario, Nucleo nucleo);
	
	public List<Area> listaAreaToZona(Zona zona);
	
}