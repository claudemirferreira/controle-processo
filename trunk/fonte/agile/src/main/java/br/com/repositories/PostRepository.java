package br.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
