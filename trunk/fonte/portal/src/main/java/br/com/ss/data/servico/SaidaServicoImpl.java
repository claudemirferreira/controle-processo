package br.com.ss.data.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ss.data.entities.Saida;
import br.com.ss.data.repositories.SaidaRepositorio;

@Service
public class SaidaServicoImpl implements SaidaServico {

	@Autowired
	private SaidaRepositorio SaidaRepositorio;

	@Override
	public List<Saida> listarTodos() {
		return this.SaidaRepositorio.findAll();
	}

	@Override
	public Saida salvar(Saida Saida) {
		return this.SaidaRepositorio.save(Saida);
	}

	@Override
	public void remover(Saida Saida) {
		this.SaidaRepositorio.delete(Saida);

	}
}