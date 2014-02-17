package br.com.ieadam.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.Perfil;

@Repository
public class PerfilRepositorioSqlImpl implements PerfilRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> listaPerfilPorSistemaPorUsuario(int sistemaId,
			Long usuarioId) {
		return entityManager.createNativeQuery(
				"SELECT distinct i.* FROM saa_perfil i, saa_usuario_perfil b "
						+ "where i.id = b.perfil_id and i.sistema_id = "
						+ sistemaId + " and b.usuario_id =  " + usuarioId,
				Perfil.class).getResultList();
	}
}