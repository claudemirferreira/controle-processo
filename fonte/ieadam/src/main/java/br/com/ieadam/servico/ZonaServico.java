package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;

public interface ZonaServico {

	public List<Zona> listarTodos();

	List<Zona> listarTodosPorSituacao(String situacao);
	
	public Zona salvar(Zona zona);

	public void remover(Zona zona);

	public List<Zona> findByMembro(int membro);
	
	public Zona findOne(int id);
	
	public List<Zona> listaZonaUsuario(int usuarioId);
	
	public boolean isUsuarioDeZona(int usuarioId, int idZona);

}