package br.com.ss.data.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ss.data.entities.Membro;
import br.com.ss.data.repositories.MembroRepositorio;

@Service
public class MembroServicoImpl implements MembroServico {

	@Autowired
	private MembroRepositorio pastorRepositorio;

	@Override
	public List<Membro> listarTodos() {
		return this.pastorRepositorio.findAll();
	}

	@Override
	public Membro salvar(Membro membro) {
		return this.pastorRepositorio.save(membro);
	}

	@Override
	public void remover(Membro membro) {
		this.pastorRepositorio.delete(membro);

	}
}