package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Perfil;

public interface PerfilRepositorioSql {

	public List<Perfil> listaPerfilPorSistemaPorUsuario(int sistemaId,
			Long usuarioId);

}