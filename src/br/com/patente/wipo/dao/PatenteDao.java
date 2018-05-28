package br.com.patente.wipo.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.patente.wipo.TipoFiltroEnum;
import br.com.patente.wipo.filter.PatenteFilter;
import br.com.patente.wipo.model.Patente;

public class PatenteDao {

	private static final String PERSISTENCE_UNIT = "patente_wipo";

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public PatenteDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		entityManager = entityManagerFactory.createEntityManager();
	}

	public Patente salvar(Patente patente) {
		entityManager.getTransaction().begin();
		Patente patenteSaved = entityManager.merge(patente);
		entityManager.getTransaction().commit();
		return patenteSaved;
	}

	public List<Patente> findAllWithFilter(PatenteFilter filtro) {

		String query = "SELECT art FROM Patente art";

		if (!Objects.isNull(filtro.getFiltro()) && !filtro.getFiltro().isEmpty()) {
			if (filtro.getTipoFiltro().equals(TipoFiltroEnum.NUMERO_PUBLICACAO.getId())) {
				query += " where NUMERO_PUBLICACAO like '%" + filtro.getFiltro() +"%'";
			} else {
				query += " where REQUERENTES like '%" + filtro.getFiltro() +"%'";
			}
		}

		TypedQuery<Patente> consulta = entityManager.createQuery(query, Patente.class);

		List<Patente> patentes = consulta.getResultList();
		return patentes;
	}

}
