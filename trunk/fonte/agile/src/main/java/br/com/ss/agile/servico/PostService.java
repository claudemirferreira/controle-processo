package br.com.ss.agile.servico;

import br.com.ss.agile.dominio.Post;

public interface PostService <Post, Integer> {
	
	public void salvar(Post post);
	
	public void excluir(Post post);
	
	public void listarTodos();

}
