package br.com.ieadam.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.ViewMembro;
import br.com.ieadam.repositorio.MembroRepositorio;
import br.com.ieadam.repositorio.MembroRepositorioSql;

@Service
public class MembroServicoImpl implements MembroServico {

	@Autowired
	private MembroRepositorio membroRepositorio;

	@Autowired
	private MembroRepositorioSql repositorioSql;
	
	@Override
	public List<Membro> listarTodos() {
		return membroRepositorio.findAll();
	}

	@Override
	public Membro salvar(Membro membro) {
		return membroRepositorio.save(membro);
	}

	@Override
	public void remover(Membro membro) {
		membroRepositorio.delete(membro);
	}


	@Override
	public List<Membro> listarMembrosPorNomeLike(String nome) {
		return this.membroRepositorio.listarMembrosPorNomeLike(nome);
	}
	
	@Override
	public List<ViewMembro> listarMembrosByFiltros(ViewMembro viewmembro) {
		return this.repositorioSql.listarMembrosByFiltros(viewmembro);
	}
}
