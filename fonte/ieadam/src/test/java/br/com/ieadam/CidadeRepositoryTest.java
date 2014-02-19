package br.com.ieadam;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Cidade;
import br.com.ieadam.repositorio.CidadeRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations =
// "classpath*:META-INF/spring/test-context.xml")
// @Ignore
public class CidadeRepositoryTest {

	@Autowired
	CidadeRepositorio repository;

	@Test
	// @Ignore
	public void test() {
		Cidade cidade = new Cidade();
		cidade.setNome("Manaus");
		cidade.setUF("AM");
		cidade.setSituacao("A");

		repository.save(cidade);

		Cidade dbpost = repository.findOne(cidade.getId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getNome());
	}

}