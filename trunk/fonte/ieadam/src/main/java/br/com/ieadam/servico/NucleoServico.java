package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Nucleo;

public interface NucleoServico {

	public List<Nucleo> listarTodos();

	public Nucleo salvar(Nucleo nucleo);

	public void remover(Nucleo nucleo);

}