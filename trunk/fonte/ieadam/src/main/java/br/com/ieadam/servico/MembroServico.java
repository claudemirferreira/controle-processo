package br.com.ieadam.servico;

import java.util.List;

import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Membro;

public interface MembroServico {

	public List<Membro> listarTodos();

	public Membro salvar(Membro membro);

	public void remover(Membro membro);
	
	public List<Membro> listarMembrosPorNomeLike(@Param("nome") String nome);

}