package br.com.uberbeer.produto;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.uberbeer.infra.JPAUtil;

public class ProdutoDao implements Serializable {

	private static final long serialVersionUID = 1117981130477623288L;

	public void salva(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(produto);
		manager.getTransaction().commit();
		
		manager.close();
	}

	public List<Produto> listaTodos() {
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<Produto> query = manager.createQuery("select p from Produto p", Produto.class);
		List<Produto> lista = query.getResultList();
		return lista;
	}

	public void remove(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		Produto produtoParaRemover = manager.find(Produto.class, produto.getId());
		manager.remove(produtoParaRemover);
		manager.getTransaction().commit();
		
		manager.close();
	}

	public void atualiza(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(produto);
		manager.getTransaction().commit();
		manager.close();
	}

	public Optional<Produto> buscaPor(Long produtoId) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Produto produto = manager.find(Produto.class, produtoId);
		
		return Optional.ofNullable(produto);
	}
	
	
}
