package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;

public interface AreaRepositorioSql {

	public List<Area> listaAreaToUsuarioAndNucleo(Usuario usuario, Nucleo nucleo);

}