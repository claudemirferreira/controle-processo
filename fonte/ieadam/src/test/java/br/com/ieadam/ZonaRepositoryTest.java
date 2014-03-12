package br.com.ieadam;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Zona;
import br.com.ieadam.dominio.enumerated.Situacao;
import br.com.ieadam.repositorio.ZonaRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations =
// "classpath*:META-INF/spring/test-context.xml")
@Ignore
public class ZonaRepositoryTest {

	@Autowired
	ZonaRepositorio repository;

	@Test
	@Ignore
	public void test() {
		Zona zona = new Zona();
		zona.setNome("ADMINISTRADOR");
		zona.setSituacao("A");

		repository.save(zona);

		Zona dbpost = repository.findOne(new Long(zona.getId()));
		assertNotNull(dbpost);
		System.out.println(dbpost.getNome());
	}

}