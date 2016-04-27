package br.com.uberbeer.produto;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	
	public void gravar() {
		ProdutoDao dao = new ProdutoDao();
		dao.salva(produto);
		produto = new Produto();
	}

	public List<Produto> getProdutos() {
		ProdutoDao dao = new ProdutoDao();
		return dao.listaTodos(); 
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
