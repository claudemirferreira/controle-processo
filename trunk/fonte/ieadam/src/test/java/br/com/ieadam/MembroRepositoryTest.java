package br.com.ieadam;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.ViewMembro;
import br.com.ieadam.repositorio.MembroRepositorioSql;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath*:META-INF/spring/test-context.xml")
@Ignore
public class MembroRepositoryTest {

	@Autowired
	MembroRepositorioSql repository;

	@Test
	public void test() {

		ViewMembro membro = new ViewMembro();
		membro.setMembro("e");

		List<ViewMembro> lista = repository.listarMembrosByFiltros(membro);
		for (ViewMembro membro2 : lista) {
			System.out.println(membro2.getMembro());
		}

	}

}