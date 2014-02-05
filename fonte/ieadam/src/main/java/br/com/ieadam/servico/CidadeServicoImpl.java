package br.com.ieadam.servico;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Cidade;
import br.com.ieadam.repositorio.CidadeRepositorio;

@Service
public class CidadeServicoImpl implements CidadeServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;

	@Autowired
	private CidadeRepositorio cidadeRepositorio;

	@Override
	public List<Cidade> listarTodos() {
		return this.cidadeRepositorio.findAll();
	}

	@Override
	public Cidade salvar(Cidade cidade) {
		return this.cidadeRepositorio.save(cidade);
	}

	@Override
	public void remover(Cidade cidade) {
		this.cidadeRepositorio.delete(cidade);

	}
}