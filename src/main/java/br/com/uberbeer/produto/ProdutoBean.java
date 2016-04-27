package br.com.uberbeer.produto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	
	public void gravar() {
		ProdutoDao dao = new ProdutoDao();
		dao.salva(produto);
		produto = new Produto();
		System.out.println("Produto salvo com sucesso!");
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
