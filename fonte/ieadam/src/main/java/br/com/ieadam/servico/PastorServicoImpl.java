package br.com.ieadam.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Pastor;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.repositorio.PastorRepositorio;

@Service
public class PastorServicoImpl implements PastorServico {

	@Autowired
	private PastorRepositorio repositorio;

	@Override
	public List<Pastor> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public Pastor salvar(Pastor pastor) {
		return repositorio.save(pastor);
	}

	@Override
	public void remover(Pastor pastor) {
		repositorio.delete(pastor);
	}

	@Override
	public Pastor findByUsuario(Usuario usuario) {
		return repositorio.findByUsuario(usuario);
	}

}