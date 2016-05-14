package br.com.uberbeer.infra;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("uberbeer");

	@Produces @RequestScoped
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public void closeConnection(@Disposes EntityManager manager) {
		manager.close();
	}

}
