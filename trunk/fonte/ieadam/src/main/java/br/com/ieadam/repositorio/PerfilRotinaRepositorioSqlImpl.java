package br.com.ieadam.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.Rotina;

@Repository
public class PerfilRotinaRepositorioSqlImpl implements
		PerfilRotinaRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Rotina> listaRotinaNotInPerfil(int idPerfil) {
		return entityManager.createNativeQuery(
				"select r.* from saa_rotina r "
				+ "where r.id_rotina not in ( "
				+ "select id_rotina from saa_perfil_rotina pr "
				+ "where pr.id_perfil = "
				+ idPerfil +")",
				Rotina.class).getResultList();

	}
}