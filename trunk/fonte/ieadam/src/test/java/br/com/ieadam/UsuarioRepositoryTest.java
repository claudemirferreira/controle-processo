package br.com.ieadam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.NivelPastoral;
import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.repositorio.MembroRepositorio;
import br.com.ieadam.repositorio.UsuarioRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath*:META-INF/spring/test-context.xml")
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepositorio repository;
	
	@Autowired
	MembroRepositorio membroRepository;

	@Test
	public void test() {
//		Usuario usuario = new Usuario();
//		usuario.setLogin("pastorzona");
//		usuario.setSenha("pastorzona");
//
//		Membro m = membroRepository.findOne(7);
//
//		usuario.setMembro(m);
//		usuario.setSituacao("a");
//
//		List<Perfil> list = new ArrayList<Perfil>();
//		Perfil p = new Perfil();
//
//		p.setId(1);
//		list.add(p);
//		
//		p = new Perfil();
//		p.setId(2);
//		list.add(p);
//
//		usuario.setPerfis(list);
		
		Usuario u = repository.findOne(16);
		
		NivelPastoral nivel = new NivelPastoral();
		nivel.setId(5);
		u.setNivelPastoral(nivel);

		repository.saveAndFlush(u);

		// Usuario dbpost = repository.findOne(usuario.getId());
		// assertNotNull(dbpost);
		// System.out.println(dbpost.getLogin());
	}

}