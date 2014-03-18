package br.com.ieadam.servico;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.repositorio.NucleoRepositorio;

@Service
public class NucleoServicoImpl implements NucleoServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;

	@Autowired
	private NucleoRepositorio repositorio;

	@Override
	public List<Nucleo> listarTodos() {
		return this.repositorio.findAll();
	}

	@Override
	public Nucleo salvar(Nucleo nucleo) {
		return this.repositorio.save(nucleo);
	}

	@Override
	public void remover(Nucleo nucleo) {
		this.repositorio.delete(nucleo);

	}

	@Override
	public List<Nucleo> findByZona(int zona) {
		return this.repositorio.findByZona(zona);
	}

	@Override
	public List<Nucleo> findByMembro(int membro) {
		return this.repositorio.findByMembro(membro);
	}
	
	public Nucleo findOne(int id) {
		return this.repositorio.findOne(id);
	}
}