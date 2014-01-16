package br.com.ieadam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ieadam.dominio.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
