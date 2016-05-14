package br.com.uberbeer.estoque;

import javax.enterprise.event.Observes;

import br.com.uberbeer.produto.ProdutoEvent;

public class Estoque {

	public void atualiza(@Observes ProdutoEvent event) {
		System.out.println("Atualizando no Estoque o Produto: " + event.getProduto());
	}
	
}
