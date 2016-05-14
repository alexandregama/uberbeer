package br.com.uberbeer.notafiscal;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;

import br.com.uberbeer.infra.JPAUtil;

@RequestScoped
public class NotaFiscalDao implements Serializable {

	private static final long serialVersionUID = 9177434243225582943L;

	public void salva(NotaFiscal notaFiscal) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(notaFiscal);
		manager.getTransaction().commit();
		manager.close();
	}

}
