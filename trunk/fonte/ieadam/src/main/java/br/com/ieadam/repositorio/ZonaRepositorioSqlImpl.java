package br.com.ieadam.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.Zona;

@Repository
public class ZonaRepositorioSqlImpl implements ZonaRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Zona> listaZonaUsuario(int usuarioId) {

		String SQL1 = "select distinct r.* from "
				+ "(select p.* from ieadam_usuario_zona z, ieadam_zona p "
				+ "where z.id_zona = p.id_zona and z.id_usuario = " + usuarioId;

		String SQL2 = " union select o.* from ieadam_usuario_nucleo n, ieadam_nucleo m, ieadam_zona o "
				+ "where m.id_nucleo = n.id_nucleo  and m.id_zona = o.id_zona and n.id_usuario = "
				+ usuarioId;

		String SQL3 = " union "
				+ "select z.* from ieadam_usuario_area n, ieadam_area m, ieadam_nucleo o, ieadam_zona z "
				+ "where m.id_area = n.id_area and o.id_nucleo = m.id_nucleo "
				+ "and z.id_zona = o.id_zona and n.id_usuario = " + usuarioId
				+ ") as r;";

		String SQL = SQL1 + SQL2 + SQL3;

		return entityManager.createNativeQuery(SQL, Zona.class).getResultList();

	}
}