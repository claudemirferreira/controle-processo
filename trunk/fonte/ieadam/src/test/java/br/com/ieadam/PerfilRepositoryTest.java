package br.com.ieadam;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.repositorio.PerfilRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath*:META-INF/spring/test-context.xml")
public class PerfilRepositoryTest {

	@Autowired
	PerfilRepositorio repository;

	@Ignore
	@Test
	public void test() {
		Perfil perfil = new Perfil();
		perfil.setNome("PERFIL 1");
		perfil.setDescricao("DESC");

		repository.save(perfil);

		perfil = new Perfil();
		perfil.setNome("PERFIL 2");
		perfil.setDescricao("DESC");

		repository.save(perfil);

		// Perfil dbperfil = repository.findOne(perfil.getPerfilId());
		// assertNotNull(dbperfil);
		// System.out.println(dbperfil.getTitle());
	}

}