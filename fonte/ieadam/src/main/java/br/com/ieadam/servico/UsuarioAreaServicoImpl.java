package br.com.ieadam.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioArea;
import br.com.ieadam.dominio.Area;
import br.com.ieadam.repositorio.UsuarioAreaRepositorio;

@Service
public class UsuarioAreaServicoImpl implements UsuarioAreaServico {

	@Autowired
	private UsuarioAreaRepositorio repositorio;

	@Override
	public List<UsuarioArea> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public UsuarioArea salvar(UsuarioArea usuarioNucleo) {
		return repositorio.saveAndFlush(usuarioNucleo);
	}

	@Override
	public void remover(UsuarioArea usuarioNucleo) {
		repositorio.delete(usuarioNucleo);
	}

	@Override
	public UsuarioArea findByUsuarioAndByArea(Usuario usuario, Area area) {
		return repositorio.findByUsuarioAndByArea(usuario,
				area);
	}

	@Override
	public void deleteByUsuarioAndByArea(Usuario usuario, Area area) {
		repositorio.deleteByUsuarioAndByArea(usuario, area);
		
	}

}