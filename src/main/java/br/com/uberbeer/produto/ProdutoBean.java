package br.com.uberbeer.produto;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.uberbeer.infra.Transactional;

@RequestScoped
@Named
public class ProdutoBean {

	@Inject
	private ProdutoDao dao;
	
	@Inject
	private Event<ProdutoEvent> produtoEvent;
	
	private Produto produto = new Produto();
	
	private List<Produto> produtos;
	
	public ProdutoBean() {
		System.out.println("Construindo ProdutoBean..");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("ProdutoBean construido");
	}
	
	@Transactional
	public void gravar() {
		if (produto.getId() == null) {
			dao.salva(produto);
			produtoEvent.fire(new ProdutoEvent(produto));
			
		} else {
			dao.atualiza(produto);
			produtoEvent.fire(new ProdutoEvent(produto));
		}
		produto = new Produto();
		produtos = null;
	}
	
	@Transactional
	public void remove(Produto produto) {
		dao.remove(produto);
		produtos = null;
	}

	public List<Produto> getProdutos() {
		System.out.println("Listando produtos..");
		if (produtos == null) {
			System.out.println("Lista de produtos vazia. Recuperando novamente..");
			produtos = dao.listaTodos();
		}
		return produtos; 
	}
	
	public void cancelar() {
		produto = new Produto();
		System.out.println("Cancelando a edicao");
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destruindo ProdutoBean..");
	}

}
