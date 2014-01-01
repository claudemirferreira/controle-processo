package br.com.servico;

import br.com.dominio.Post;

public interface PostService <Post, Integer> {
	
	public void salvar(Post post);
	
	public void excluir(Post post);
	
	public void listarTodos();

}
