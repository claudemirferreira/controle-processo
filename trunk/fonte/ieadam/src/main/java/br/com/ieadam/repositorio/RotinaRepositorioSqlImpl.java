package br.com.ieadam.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.Rotina;

@Repository
public class RotinaRepositorioSqlImpl implements RotinaRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Rotina> listaRotinasPorPerfil(int id) {
		return entityManager
				.createNativeQuery(
						"SELECT i.* FROM ieadam_rotina i, perfil_rotina b where i.id = b.rotina_id and perfil_id = " + id,
						Rotina.class).getResultList();

	}
}