package br.com.controlador;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.stereotype.Controller;

import br.com.dominio.Post;
import br.com.servico.PostService;


@ManagedBean
//@Controller
public class PostControlador {
	
	@ManagedProperty(value = "#{postServiceImpl}")
	private PostService<Post, Integer> postService;
	
	public void init(){
		
		Post p = new Post();
		p.setPostDate(new Date());
		p.setTitle("wwwwwwwwwwwwwwwwww");
		
		System.out.println("alooooooooooooo");
		postService.salvar(p);
	}

	public PostService<Post, Integer> getPostService() {
		return postService;
	}

	public void setPostService(PostService<Post, Integer> postService) {
		this.postService = postService;
	}

	

}
