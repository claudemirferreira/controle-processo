package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Rotina;

public interface PerfilRotinaRepositorioSql {

	public List<Rotina> listaRotinaNotInPerfil(int idPerfil);

}