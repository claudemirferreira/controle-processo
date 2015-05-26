package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.ViewMembro;

public interface MembroRepositorioSql {
	
	public List<ViewMembro> listarMembrosByFiltros(ViewMembro viewMembro);

}