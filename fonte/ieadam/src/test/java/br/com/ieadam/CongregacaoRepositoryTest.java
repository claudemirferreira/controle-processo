package br.com.ieadam;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.repositorio.CongregacaoRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations =
// "classpath*:META-INF/spring/test-context.xml")
public class CongregacaoRepositoryTest {

	@Autowired
	CongregacaoRepositorio repository;

	@Test
	// @Ignore
	public void test() {
		// Congregacao zona = new Congregacao();
		// zona.setNome("ADMINISTRADOR");
		// zona.setSituacao(Situacao.ATIVO);
		//
		// Cidade cidade = new Cidade();
		// cidade.setId(1);
		//
		// zona.setCidade(cidade);
		//
		// Area area = new Area();
		// area.setId(1);
		//
		// zona.setArea(area);
		//
		// zona.setBairro("CIDADE NOVA");
		// zona.setEndereco("wwwww");
		// zona.setCep("7777777");

		List<Congregacao> list = repository.findAll();

		System.out.println(list.size());
	}

}