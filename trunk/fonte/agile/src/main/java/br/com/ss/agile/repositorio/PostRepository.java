package br.com.ss.agile.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ss.agile.dominio.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
