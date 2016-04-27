package br.com.uberbeer.produto;

import javax.persistence.EntityManager;

import br.com.uberbeer.infra.JPAUtil;

public class ProdutoDao {

	public void salva(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(produto);
		manager.getTransaction().commit();
		
		manager.close();
	}

	
	
}
