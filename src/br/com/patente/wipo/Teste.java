package br.com.patente.wipo;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.patente.wipo.model.Patente;

public class Teste {

	private static final String PERSISTENCE_UNIT_NAME = "patente_wipo";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Patente processo = new Patente();
		processo.setNumeroPublicacao("Teste");
		processo.setNumeroPedidoInternacional("NUMPEDINTER");
		processo.setRequerentes("Requerentes");
		processo.setTitulo("Titulo");
		processo.setDataPublicacao(LocalDate.now());
		em.persist(processo);
		em.getTransaction().commit();
		em.close();

	}

}
