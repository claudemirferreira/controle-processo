package br.com.ieadam.servico;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.repositorio.AreaRepositorio;
import br.com.ieadam.repositorio.AreaRepositorioSql;

@Service
public class AreaServicoImpl implements AreaServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;

	@Autowired
	private AreaRepositorio repositorio;

	@Autowired
	private AreaRepositorioSql repositorioSql;

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
	public List<Area> findByNucleo(int nucleo) {
		return this.repositorio.findByNucleo(nucleo);
	}

	@Override
	public List<Area> findByMembro(int membro) {
		return this.repositorio.findByMembro(membro);
	}

	@Override
	public List<Area> findByMembroAndNucleo(int membro, int idNucleo) {
		return this.repositorio.findByMembroAndNucleo(membro, idNucleo);
	}

	@Override
	public List<Area> listaAreaToUsuarioAndNucleo(Usuario usuario, Nucleo nucleo) {
		return repositorioSql.listaAreaToUsuarioAndNucleo(usuario, nucleo);
	}

	@Override
	public List<Area> listaAreaToZona(Zona zona) {
		return repositorioSql.listaAreaToZona(zona);
	}
	
}