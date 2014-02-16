package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Zona;

public interface ZonaServico {

	public List<Zona> listarTodos();

	public Zona salvar(Zona zona);

	public void remover(Zona zona);

}