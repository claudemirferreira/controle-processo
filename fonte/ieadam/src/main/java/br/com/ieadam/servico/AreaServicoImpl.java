package br.com.ieadam.servico;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.repositorio.AreaRepositorio;

@Service
public class AreaServicoImpl implements AreaServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;

	@Autowired
	private AreaRepositorio repositorio;

	@Override
	public List<Area> listarTodos() {
		return this.repositorio.findAll();
	}

	@Override
	public Area salvar(Area area) {
		return this.repositorio.save(area);
	}

	@Override
	public void remover(Area area) {
		this.repositorio.delete(area);

	}

	@Override
	public List<Area> findByNucleo(Nucleo nucleo) {
		return this.repositorio.findByNucleo(nucleo);
	}

	@Override
	public List<Area> findByMembro(Membro membro) {
		return this.repositorio.findByMembro(membro);
	}
}