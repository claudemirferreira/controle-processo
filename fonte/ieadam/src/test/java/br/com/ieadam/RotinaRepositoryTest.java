package br.com.ieadam;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Rotina;
import br.com.ieadam.repositorio.RotinaRepositorioSql;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations =
// "classpath*:META-INF/spring/test-context.xml")
public class RotinaRepositoryTest {

	@Autowired
	RotinaRepositorioSql repository;

	@Test
	// @Ignore
	public void test() {

		List<Rotina> list = repository.listaRotinasPorPerfil(2);
		for (Rotina rotina : list) {
			System.out.println(rotina.getNome());

		}

	}

}