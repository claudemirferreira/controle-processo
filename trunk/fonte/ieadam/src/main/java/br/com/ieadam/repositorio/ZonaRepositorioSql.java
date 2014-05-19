package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Zona;

public interface ZonaRepositorioSql {

	public List<Zona> listaZonaUsuario(int usuarioId);

}