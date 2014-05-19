package br.com.ieadam.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;

@Repository
public class NucleoRepositorioSqlImpl implements NucleoRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Nucleo> listaNucleoUsuario(Usuario usuario) {
		
		String SQL1 = "select DISTINCT R.* from "
				+ "(select b.* from ieadam_usuario_nucleo a, ieadam_nucleo b, ieadam_area c "
				+ "where b.id_nucleo = a.id_nucleo and b.id_nucleo = c.id_nucleo and a.id_usuario ="  + usuario.getId();
		
		String SQL2 = " union select b.* from ieadam_area a, ieadam_nucleo b, ieadam_usuario_nucleo c "
				+ "where a.id_nucleo = b.id_nucleo and c.id_nucleo = b.id_nucleo "
				+ "and c.id_usuario = "  + usuario.getId() 
				+ " and a.id_pastor = "  + usuario.getIdMembro()
				+ ") AS R;";

		String SQL = SQL1 + SQL2;

		return entityManager.createNativeQuery(SQL, Zona.class).getResultList();
	}
}