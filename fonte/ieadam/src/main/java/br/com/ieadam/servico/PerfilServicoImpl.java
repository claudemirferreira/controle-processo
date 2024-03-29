package br.com.ieadam.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.repositorio.PerfilRepositorio;
import br.com.ieadam.repositorio.PerfilRepositorioSql;

@Service
public class PerfilServicoImpl implements PerfilServico {

	@Autowired
	private PerfilRepositorio perfilRepositorio;

	@Autowired
	private PerfilRepositorioSql perfilRepositorioSql;

	@Override
	public List<Perfil> listarTodos() {
		return this.perfilRepositorio.findAll();
	}

	@Override
	public Perfil salvar(Perfil perfil) {
		return this.perfilRepositorio.save(perfil);
	}

	@Override
	public void remover(Perfil perfil) {
		this.perfilRepositorio.delete(perfil);
	}

	@Override
	public List<Perfil> findByNomeLike(String nome) {
		return this.perfilRepositorio.findByNomeLike(nome);
	}

	@Override
	public List<Perfil> listaPerfilPorSistemaPorUsuario(int sistemaId,
			int usuarioId) {
		return this.perfilRepositorioSql.listaPerfilPorSistemaPorUsuario(
				sistemaId, usuarioId);
	}
}