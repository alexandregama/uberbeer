package br.com.uberbeer.produto;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	
	private List<Produto> produtos;
	
	public ProdutoBean() {
		System.out.println("Construindo ProdutoBean..");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("ProdutoBean construido");
	}
	
	public void gravar() {
		ProdutoDao dao = new ProdutoDao();
		dao.salva(produto);
		produto = new Produto();
		System.out.println("Produto gravado com sucesso!");
	}

	public List<Produto> getProdutos() {
		System.out.println("Listando produtos..");
		if (produtos == null) {
			System.out.println("Lista de produtos vazia. Recuperando novamente..");
			ProdutoDao dao = new ProdutoDao();
			produtos = dao.listaTodos();
		}
		return produtos; 
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
