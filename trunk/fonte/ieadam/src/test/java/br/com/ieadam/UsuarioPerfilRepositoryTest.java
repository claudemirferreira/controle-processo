package br.com.ieadam;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioPerfil;
import br.com.ieadam.repositorio.PerfilRepositorio;
import br.com.ieadam.repositorio.UsuarioPerfilRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath*:META-INF/spring/test-context.xml")
public class UsuarioPerfilRepositoryTest {

	@Autowired
	UsuarioPerfilRepositorio repository;

	@Test
	public void test() {

		UsuarioPerfil u = new UsuarioPerfil();
		
		u.setId(63l);
		
		Perfil p = new Perfil();
		p.setId(1l);
		
		u.setPerfil(p);
		
		Usuario us = new Usuario();
		us.setId(2l);
		
		u.setUsuario(us);
		
		repository.delete(u);

//		List<Perfil> perfis = repository.listarPerfilPorUsuario(2);

		// assertNotNull(perfis);

		// Perfil dbperfil = repository.findOne(perfil.getPerfilId());
		// assertNotNull(dbperfil);
		// System.out.println(dbperfil.getTitle());
	}

}