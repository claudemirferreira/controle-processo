package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Congregacao;

public interface CongregacaoServico {

	public List<Congregacao> listarTodos();

	public Congregacao salvar(Congregacao congregacao);

	public void remover(Congregacao congregacao);

}