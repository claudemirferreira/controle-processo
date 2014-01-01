package br.com;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.entities.Post;
import br.com.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/applicationContext.xml")
//@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class PostRepositoryTest {

	@Autowired
	PostRepository repository;
	
	@Test
	public void test() {
		Post post = new Post();
		post.setPostDate(new Date());
		post.setTitle("First Post");
		
		repository.save(post);
		
		Post dbpost = repository.findOne(post.getPostId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getTitle());
	}

}
