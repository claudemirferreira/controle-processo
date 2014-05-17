package br.com.ieadam.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioNucleo;
import br.com.ieadam.repositorio.UsuarioNucleoRepositorio;

@Service
public class UsuarioNucleoServicoImpl implements UsuarioNucleoServico {

	@Autowired
	private UsuarioNucleoRepositorio repositorio;

	@Override
	public List<UsuarioNucleo> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public UsuarioNucleo salvar(UsuarioNucleo usuarioNucleo) {
		return repositorio.saveAndFlush(usuarioNucleo);
	}

	@Override
	public void remover(UsuarioNucleo usuarioNucleo) {
		repositorio.delete(usuarioNucleo);
	}

	@Override
	public UsuarioNucleo findByUsuarioAndByNucleo(Usuario usuario, Nucleo nucleo) {
		return repositorio.findByUsuarioAndByNucleo(usuario, nucleo);
	}

	@Override
	public void deleteByUsuarioAndByNucleo(Usuario usuario, Nucleo nucleo) {
		repositorio.deleteByUsuarioAndByNucleo(usuario, nucleo);

	}

	@Override
	public List<Nucleo> findByUsuario(Usuario usuario) {
		
		List<UsuarioNucleo> lista = repositorio.findByUsuario(usuario);
		List<Nucleo> nucleos = new ArrayList<Nucleo>();
		
		for (UsuarioNucleo usuarioNucleo : lista) {
			nucleos.add(usuarioNucleo.getNucleo());
		}
		
		return nucleos;
	}
}