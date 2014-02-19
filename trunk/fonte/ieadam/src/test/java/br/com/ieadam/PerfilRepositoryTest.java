package br.com.ieadam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Perfil;
import br.com.ieadam.dominio.Sistema;
import br.com.ieadam.repositorio.PerfilRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
public class PerfilRepositoryTest {

	@Autowired
	PerfilRepositorio repository;

	
	@Test
	public void testInsert() {
		
		Sistema sistema = new Sistema(); 
		sistema.setIdSistema(1L);
		
		Perfil perfil = new Perfil();
		perfil.setImagem("imagem");
		perfil.setNome("Perfil Teste");
		perfil.setSistema(sistema);

		repository.saveAndFlush(perfil);
		
	}
	
	
}