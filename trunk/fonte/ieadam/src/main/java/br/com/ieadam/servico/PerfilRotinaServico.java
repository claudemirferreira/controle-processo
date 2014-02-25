package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.PerfilRotina;
import br.com.ieadam.dominio.Rotina;

public interface PerfilRotinaServico {

	public List<PerfilRotina> listarTodos();

	public PerfilRotina salvar(PerfilRotina usuarioPerfil);

	public void remover(PerfilRotina usuarioPerfil);

	public List<Rotina> listaRotinaNotInPerfil(Long idPerfil);
	
}
