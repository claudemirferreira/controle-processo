package br.com.ieadam;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioPerfil;
import br.com.ieadam.dominio.UsuarioPerfilPk;
import br.com.ieadam.repositorio.UsuarioPerfilRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath:META-INF/test-context.xml")
//@Ignore
public class UsuarioPerfilRepositoryTest {

	@Autowired
	UsuarioPerfilRepositorio repository;

	@Test
	public void test() {
		Perfil p = new Perfil();
		p.setIdPerfil(4l);
		
		Usuario u = new Usuario();
		u.setIdUsuario(1l);
		
		UsuarioPerfilPk upk = new UsuarioPerfilPk();
		upk.setPerfil(p);
		upk.setUsuario(u);
		
		UsuarioPerfil up = new UsuarioPerfil();
		up.setUsuarioPerfilPk(upk);
		
		repository.save(up);
		
		
	}
}
