package br.com.ieadam;

import java.util.HashSet;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.repositorio.UsuarioRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath*:META-INF/spring/test-context.xml")
@Ignore
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepositorio repository;

	@Test
	public void test() {
		Usuario usuario = new Usuario();
		usuario.setLogin("teste");
		usuario.setSenha("teste");

		Membro m = new Membro();
		m.setCpf("11111111111");
		m.setNome("teste ");
		m.setSexo("M");

		usuario.setMembro(m);
		// m.setUsuario(usuario);

		Perfil p = new Perfil();
		p.setId(1);
		Set<Perfil> list = new HashSet<Perfil>();
		list.add(p);

		usuario.setPerfis(list);

		repository.save(usuario);

		// Usuario dbpost = repository.findOne(usuario.getId());
		// assertNotNull(dbpost);
		// System.out.println(dbpost.getLogin());
	}

}