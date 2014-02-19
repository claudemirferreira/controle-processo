package br.com.ieadam;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Rotina;
import br.com.ieadam.dominio.Sistema;
import br.com.ieadam.repositorio.RotinaRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath*:META-INF/spring/test-context.xml")
@Ignore
public class RotinaRepositoryTest {

	@Autowired
	RotinaRepositorio repository;
	
	@Test
	public void test() {
		
		Rotina rotina = new Rotina();
		rotina.setImagem("wwww");
		rotina.setNome("wwww");
		
		Sistema sistema = new Sistema();
		
		sistema.setIdSistema(1L);
		rotina.setSistema(sistema);
		
		Rotina u = repository.save(rotina);
		
		
	}

}