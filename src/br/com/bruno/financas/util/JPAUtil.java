package br.com.bruno.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Financas");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
