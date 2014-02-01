package br.com.ieadam.servico;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Usuario;

public interface MembroServico {

	public List<Membro> listarTodos();

	public Membro salvar(Membro membro);

	public void remover(Membro membro);
	
	@Query("select m from membro m where m.usuario = :usuario")
	public Membro findByUsuario(@Param("usuario") Usuario usuario);
	
	public List<Membro> listarMembrosPorNomeLike(@Param("nome") String nome);

}