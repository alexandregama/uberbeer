package br.com.uberbeer.produto;

public class ProdutoEvent {

	private Produto produto;

	public ProdutoEvent(Produto produto) {
		this.produto = produto;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
}
