package br.com.ieadam.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Zona;

@Repository
public class MembroRepositorioSqlImpl extends RepositorioGenerico implements
		MembroRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Membro> pesquisaAvancada(Zona zona, Nucleo nucleo, Area area,
			Congregacao congregacao, Membro membro) {

		String SQL = "select b.* from ieadam_area b, ieadam_usuario_area c "
				+ " where b.id_area = c.id_area " + " and b.id_nucleo = "
				+ nucleo.getId();

		return entityManager.createNativeQuery(SQL, Area.class).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Membro> findByMembro(Membro membro, Congregacao congregacao) {

		StringBuilder sb = new StringBuilder();
		List<String> condictions = new ArrayList<String>();

		sb.append(" select mem from Membro usu ");
		if (notEmpty(membro)) {
			if (notEmpty(membro.getNome())) {
				condictions.add(" lower( mem.nome ) like :nome ");
			}
		}

		String orderBy = " order by mem.nome ";

		Query query = entityManager.createQuery(generateHql(sb.toString(),
				condictions) + orderBy);

		if (notEmpty(membro)) {
			if (notEmpty(membro.getNome())) {
				query.setParameter("nome", "%" + membro.getNome() + "%");
			}
		}

		return query.getResultList();
	}

	public List<Membro> pesquisar(Membro membro, Congregacao congregacao) {
		StringBuilder sb = new StringBuilder();
		List<String> condictions = new ArrayList<String>();

		sb.append(" select mem from Membro mem ");
		sb.append(" join fetch mem.congragacao cong ");

		if (notEmpty(membro)) {
			if (notEmpty(membro.getNome())) {
				condictions.add(" lower( mem.nome ) like :nome ");
			}
		}
		if (notEmpty(congregacao) && congregacao.getIdCongregacao() > 0) {
			condictions.add(" mem.congregacao.idCongregacao = :idCongregacao");
		}
		String orderBy = " order by mem.nome ";

		Query query = entityManager.createQuery(generateHql(sb.toString(),
				condictions) + orderBy);

		if (notEmpty(membro)) {
			if (notEmpty(membro.getNome())) {
				query.setParameter("nome", "%" + membro.getNome() + "%");
			}
		}

		if (notEmpty(congregacao)) {
			if (notEmpty(congregacao.getIdCongregacao())) {
				query.setParameter("idCongregacao",
						congregacao.getIdCongregacao());
			}
		}

		return query.getResultList();
	}

}