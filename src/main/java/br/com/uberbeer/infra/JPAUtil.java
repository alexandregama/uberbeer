package br.com.uberbeer.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("uberbeer");
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
