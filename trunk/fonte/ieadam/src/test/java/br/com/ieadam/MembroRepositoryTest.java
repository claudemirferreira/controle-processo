package br.com.ieadam;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Cidade;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.repositorio.MembroRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath*:META-INF/spring/test-context.xml")
public class MembroRepositoryTest {

	@Autowired
	MembroRepositorio repository;

	@Test
	public void test() {
		Membro membro = new Membro();
		membro.setNome("PASTOR DE ZONA");
		membro.setCpf("44444444444");
		membro.setFatorRH("o+");
		membro.setNacionalidade("Brasileiro");
		membro.setSexo("M");
		membro.setSituacao("a");
		membro.setUf("AM");
		
		Cidade cidade = new Cidade();
		cidade.setId(1);;
		membro.setCidade(cidade);
		
		Usuario u = new Usuario();
		u.setSituacao("a");
		membro.setUsuario(u);
		repository.saveAndFlush(membro);

		Membro dbpost = repository.findOne(membro.getId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getNome());
	}

}