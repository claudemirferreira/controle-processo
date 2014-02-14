package br.com.ieadam;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.NivelPastoral;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.repositorio.NivelPastoralRepositorio;
import br.com.ieadam.repositorio.UsuarioRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
public class NivelPastoralTest {

	@Autowired
	NivelPastoralRepositorio repository;
	
	@Autowired
	UsuarioRepositorio usuarioRepository;

	@Test
	public void test() {
		
		Usuario u = usuarioRepository.findOne(16);
		
		NivelPastoral nivel = new NivelPastoral();
		nivel.setArea_id(0);
		nivel.setNucleo_id(0);
		nivel.setZona_id(1);
		nivel.setUsuario(u);
		
		repository.saveAndFlush(nivel);

		NivelPastoral dbpost = repository.findOne(nivel.getId());
		assertNotNull(dbpost);
	}
}
