package br.com.ieadam.servico;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.repositorio.CongregacaoRepositorio;

@Service
public class CongregacaoServicoImpl implements CongregacaoServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;
	
	@Autowired
	private CongregacaoRepositorio congregacaoRepositorio;

	@Override
	public List<Congregacao> listarTodos() {
		return this.congregacaoRepositorio.findAll();
	}

	@Override
	public Congregacao salvar(Congregacao congregacao) {
		return this.congregacaoRepositorio.save(congregacao);
	}

	@Override
	public void remover(Congregacao congregacao) {
		this.congregacaoRepositorio.delete(congregacao);

	}
}