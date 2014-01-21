package br.com.ieadam;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Situacao;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.repositorio.UsuarioRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath*:META-INF/spring/test-context.xml")
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepositorio repository;

	@Test
	public void test() {
		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		usuario.setSituacao(Situacao.ATIVO);

		repository.save(usuario);

		Usuario dbpost = repository.findOne(usuario.getId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getLogin());
	}

}