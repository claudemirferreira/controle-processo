package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;

public interface NucleoRepositorioSql {

	public List<Nucleo> listaNucleoUsuario(Usuario usuario);
	
	public List<Nucleo> listaNucleoPorArea(Usuario usuario);
	
	public List<Nucleo> listaNucleoToUsuarioAndZona(Usuario usuario, Zona zona);
	
	public boolean isUsuarioDeNucleo(int usuarioId, int idNucleo);

}