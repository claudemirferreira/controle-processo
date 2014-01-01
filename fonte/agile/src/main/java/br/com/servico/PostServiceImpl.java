package br.com.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dominio.Post;
import br.com.repositorio.PostRepository;

@Service
@Transactional
public class PostServiceImpl implements PostService<Post, Integer>{
	
	@Autowired
	private PostRepository postRepository;
	
	public void salvar(Post post){
		postRepository.saveAndFlush(post);
	}
	
	public void excluir(Post post){
		postRepository.delete(post);
	}
	
	public void listarTodos(){
		postRepository.findAll();
	}

}