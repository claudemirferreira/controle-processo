package br.com.ieadam.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;

@Repository
public class AreaRepositorioSqlImpl implements AreaRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> listaAreaToUsuarioAndNucleo(Usuario usuario, Nucleo nucleo) {

		String SQL = "select b.* from ieadam_area b, ieadam_usuario_area c "
				+ " where b.id_area = c.id_area " + " and b.id_nucleo = "
				+ nucleo.getId() + " and c.id_usuario = " + usuario.getId();

		return entityManager.createNativeQuery(SQL, Area.class).getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Area> listaAreaToZona(Zona zona) {

		String SQL = "select a.* from sgr.ieadam_area a, sgr.ieadam_nucleo b, sgr.ieadam_zona c "
				+ "where a.id_nucleo = b.id_nucleo and b.id_zona = c.id_zona "
				+ "and c.id_zona =" + zona.getIdZona();

		return entityManager.createNativeQuery(SQL, Area.class).getResultList();
	}
}