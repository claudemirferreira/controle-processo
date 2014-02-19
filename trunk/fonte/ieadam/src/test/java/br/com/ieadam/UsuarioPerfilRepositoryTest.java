package br.com.ieadam;

import java.util.Date;

import org.junit.Assert;
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
import br.com.ieadam.repositorio.UsuarioRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class UsuarioPerfilRepositoryTest {

	@Autowired
	UsuarioPerfilRepositorio repository;

	@Autowired
	UsuarioRepositorio repositoryUsuario;

	@Autowired
	PerfilRepositorio repositoryPerfil;

	private static Long id = 1L;
	
	@Test
	public void testCreate() {
		Perfil perfil = getPerfil();
		Assert.assertNotNull(perfil);
		
		Usuario usuario = getUsuario();
		Assert.assertNotNull(usuario); 
		
		UsuarioPerfil up = new UsuarioPerfil();
		up.setData(new Date());
		up.setPerfil(perfil);
		up.setUsuario(usuario);
		
		repository.save(up);

		Assert.assertNotNull(up.getIdUsuarioPerfil());
		
		// para o teste de delete
		id = up.getIdUsuarioPerfil();
		
		UsuarioPerfil upQuery = repository.findOne(up.getIdUsuarioPerfil());

		Assert.assertNotNull(upQuery);
		
	}
	
	@Test
	public void testDelete() {
		
		UsuarioPerfil up = repository.findOne(id);
		
		Assert.assertNotNull(up);
		Assert.assertEquals(up.getIdUsuarioPerfil(), id);
		
		repository.delete(up);
		
		up = repository.findOne(id);
		Assert.assertNull(up);
		
	}
	
	
	

	private Usuario getUsuario() {
		return repositoryUsuario.findOne(1L);
	}

	private Perfil getPerfil() {
		return repositoryPerfil.findOne(1L);
	}
}
