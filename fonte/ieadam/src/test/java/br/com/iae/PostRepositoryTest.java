package br.com.iae;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Post;
import br.com.ieadam.repositorio.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:META-INF/spring/applicationContext.xml")
@ContextConfiguration(locations="classpath:META-INF/spring/test-context.xml")
@Ignore
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
