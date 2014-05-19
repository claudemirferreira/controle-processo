package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;

public interface NucleoRepositorioSql {

	public List<Nucleo> listaNucleoUsuario(Usuario usuario);

}