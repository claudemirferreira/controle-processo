package br.com.ieadam.servico;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.repositorio.ZonaRepositorio;
import br.com.ieadam.repositorio.ZonaRepositorioSql;

@Service
public class ZonaServicoImpl implements ZonaServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;

	@Autowired
	private ZonaRepositorio zonaRepositorio;
	
	@Autowired
	private ZonaRepositorioSql zonaRepositorioSql;

	@Override
	public List<Zona> listarTodos() {
		return this.zonaRepositorio.findAll();
	}

	@Override
	public List<Zona> listarTodosPorSituacao(String situacao) {
		return this.zonaRepositorio.findAllBySituacao(situacao);
	}
	
	@Override
	public Zona salvar(Zona zona) {
		return this.zonaRepositorio.save(zona);
	}

	@Override
	public void remover(Zona zona) {
		this.zonaRepositorio.delete(zona);

	}

	@Override
	public List<Zona> findByMembro(int membro) {
		return this.zonaRepositorio.findByMembro(membro);
	}
	
	public Zona findOne(int id) {
		return this.zonaRepositorio.findOne(id);
	}

	@Override
	public List<Zona> listaZonaUsuario(int usuarioId) {
		return zonaRepositorioSql.listaZonaUsuario(usuarioId);
	}

	@Override
	public boolean isUsuarioDeZona(int usuarioId, int idZona) {
		return zonaRepositorioSql.isUsuarioDeZona(usuarioId, idZona);
	}

}