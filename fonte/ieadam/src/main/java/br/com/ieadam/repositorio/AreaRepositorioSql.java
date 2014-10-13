package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;

public interface AreaRepositorioSql {

	public List<Area> listaAreaToUsuarioAndNucleo(Usuario usuario, Nucleo nucleo);

	public List<Area> listaAreaToZona(Zona zona);

}