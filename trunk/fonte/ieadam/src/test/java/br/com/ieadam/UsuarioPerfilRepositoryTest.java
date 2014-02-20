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
import br.com.ieadam.dominio.UsuarioPerfilPk;
import br.com.ieadam.repositorio.UsuarioPerfilRepositorioSql;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath:META-INF/test-context.xml")
// @Ignore
public class UsuarioPerfilRepositoryTest {

	@Autowired
	UsuarioPerfilRepositorioSql repository;

	@Test
	public void test() {
		Perfil p = new Perfil();
		p.setIdPerfil(1l);

		Usuario u = new Usuario();
		u.setIdUsuario(1l);

		UsuarioPerfilPk upk = new UsuarioPerfilPk();
		upk.setPerfil(p);
		upk.setUsuario(u);

		UsuarioPerfil up = new UsuarioPerfil();
		up.setUsuarioPerfilPk(upk);

		List<Perfil> lista = repository.listaPerfilNotInUsuario(u.getIdUsuario());
		for (Perfil usuarioPerfil : lista) {

			System.out.println(usuarioPerfil.getNome());

		}

	}
}
