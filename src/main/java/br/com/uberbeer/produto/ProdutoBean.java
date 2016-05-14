package br.com.uberbeer.produto;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.uberbeer.infra.Transactional;

@RequestScoped
@Named
public class ProdutoBean {

	@Inject
	private ProdutoDao dao;
	
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
		} else {
			dao.atualiza(produto);
		}
		produto = new Produto();
		produtos = null;
		System.out.println("Produto gravado com sucesso!");
	}
	
	@Transactional
	public void remove(Produto produto) {
		dao.remove(produto);
		produtos = null;
		System.out.println("Produto removido com sucesso!");
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
