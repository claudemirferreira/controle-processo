package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Membro;

public interface MembroServico {

	public List<Membro> listarTodos();

	public Membro salvar(Membro membro);

	public void remover(Membro membro);

}