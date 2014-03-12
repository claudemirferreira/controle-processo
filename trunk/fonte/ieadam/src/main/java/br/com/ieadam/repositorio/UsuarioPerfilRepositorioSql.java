package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Perfil;

public interface UsuarioPerfilRepositorioSql {

	public List<Perfil> listaPerfilNotInUsuario(int idUsuario);

}