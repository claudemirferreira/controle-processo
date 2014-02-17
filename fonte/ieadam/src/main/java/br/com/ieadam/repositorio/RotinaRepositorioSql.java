package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Rotina;

public interface RotinaRepositorioSql {

	public List<Rotina> listaRotinasPorPerfil(Long id);

}
