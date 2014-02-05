package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Cidade;

public interface CidadeServico {

	public List<Cidade> listarTodos();

	public Cidade salvar(Cidade cidade);

	public void remover(Cidade cidade);

}