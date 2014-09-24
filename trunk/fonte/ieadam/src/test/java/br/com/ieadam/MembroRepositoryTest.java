package br.com.ieadam;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.repositorio.MembroRepositorioSql;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
// @ContextConfiguration(locations="classpath*:META-INF/spring/test-context.xml")
public class MembroRepositoryTest {

	@Autowired
	MembroRepositorioSql repository;

	@Test
	public void test() {

		Membro membro = new Membro();
		membro.setNome("e");

		Congregacao cong = new Congregacao();

		cong.setIdCongregacao(2);

		List<Membro> lista = repository.pesquisar(membro, cong);
		for (Membro membro2 : lista) {
			System.out.println(membro2.getNome());
		}

	}

}