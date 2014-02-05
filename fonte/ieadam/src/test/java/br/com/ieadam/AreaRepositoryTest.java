package br.com.ieadam;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.enumerated.Situacao;
import br.com.ieadam.repositorio.AreaRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
//@ContextConfiguration(locations = "classpath*:META-INF/spring/test-context.xml")
public class AreaRepositoryTest {

	@Autowired
	AreaRepositorio repository;

	@Test
//	@Ignore
	public void test() {
		Area area = new Area();
		area.setNome("ADMINISTRADOR");
		area.setSituacao(Situacao.ATIVO);

		Nucleo n = new Nucleo();
		n.setId(1);

		area.setNucleo(n);

		repository.save(area);

		Area dbpost = repository.findOne(area.getId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getNome());
	}

}