package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Rotina;

public interface RotinaServico {

	public List<Rotina> listarTodos();

	public Rotina salvar(Rotina rotina);

	public void remover(Rotina rotina);

	public List<Rotina> listaRotinasPorPerfil(int id);

	public List<Rotina> findByNomeLike(String nome);

}