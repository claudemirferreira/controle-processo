package br.com.ieadam.servico;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.repositorio.AreaRepositorio;

@Service
public class AreaServicoImpl implements AreaServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;

	@Autowired
	private AreaRepositorio areaRepositorio;

	@Override
	public List<Area> listarTodos() {
		return this.areaRepositorio.findAll();
	}

	@Override
	public Area salvar(Area area) {
		return this.areaRepositorio.save(area);
	}

	@Override
	public void remover(Area area) {
		this.areaRepositorio.delete(area);

	}
}