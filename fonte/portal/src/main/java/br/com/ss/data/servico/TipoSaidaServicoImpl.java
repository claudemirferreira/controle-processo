package br.com.ss.data.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ss.data.entities.TipoSaida;
import br.com.ss.data.repositories.TipoSaidaRepositorio;

@Service
public class TipoSaidaServicoImpl implements TipoSaidaServico {

	@Autowired
	private TipoSaidaRepositorio tipoSaidaRepositorio;

	@Override
	public List<TipoSaida> listarTodos() {
		return this.tipoSaidaRepositorio.findAll();
	}

	@Override
	public TipoSaida salvar(TipoSaida tipoSaida) {
		return this.tipoSaidaRepositorio.save(tipoSaida);
	}

	@Override
	public void remover(TipoSaida tipoSaida) {
		this.tipoSaidaRepositorio.delete(tipoSaida);

	}
}