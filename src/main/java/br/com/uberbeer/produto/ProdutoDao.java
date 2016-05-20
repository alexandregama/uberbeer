package br.com.uberbeer.produto;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.uberbeer.infra.JPAUtil;

@RequestScoped
public class ProdutoDao implements Serializable {

	private static final long serialVersionUID = 1117981130477623288L;

	@Inject
	private EntityManager manager;

	public void salva(Produto produto) {
		manager.persist(produto);
	}

	public List<Produto> listaTodos() {
		TypedQuery<Produto> query = manager.createQuery("select p from Produto p", Produto.class);
		List<Produto> lista = query.getResultList();
		return lista;
	}

	public void remove(Produto produto) {
		Produto produtoParaRemover = manager.find(Produto.class, produto.getId());
		manager.remove(produtoParaRemover);
	}

	public void atualiza(Produto produto) {
		manager.merge(produto);
	}

	public Optional<Produto> buscaPor(Long produtoId) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Produto produto = manager.find(Produto.class, produtoId);

		return Optional.ofNullable(produto);
	}

	public int totalDeProdutos() {
		String jpql = "select count(p) from Produto p";
		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
		
		return query.getSingleResult().intValue();
	}

	public List<Produto> listaPaginado(int inicio, int fim) {
		String jpql = "select p from Produto p";
		TypedQuery<Produto> query = manager.createQuery(jpql, Produto.class);
		query.setFirstResult(inicio);
		query.setMaxResults(fim);
		
		return query.getResultList();
	}

}
