package br.com.uberbeer.notafiscal;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.uberbeer.produto.Produto;
import br.com.uberbeer.produto.ProdutoDao;

@ViewScoped
@Named
public class NotaFiscalBean implements Serializable {

	private static final long serialVersionUID = 8078388828711251442L;

	@Inject
	private ProdutoDao produtoDao;
	
	@Inject
	private NotaFiscalDao notaFiscalDao;
	
	private NotaFiscal notaFiscal = new NotaFiscal();
	
	private Long produtoId = 0L;
	
	private Item item = new Item();

	public void adicionaItem() {
		Optional<Produto> produto = produtoDao.buscaPor(produtoId);
		if (produto.isPresent()) {
			item.setProduto(produto.get());
			item.setValorUnitario(produto.get().getPreco());
			item.setNotaFiscal(notaFiscal);
			notaFiscal.adiciona(item);
			atualizaItemNoFormulario();
		}
	}
	
	public void salvarNota() {
		notaFiscalDao.salva(notaFiscal);
		notaFiscal = new NotaFiscal();
	}

	public void remove(Item item) {
		notaFiscal.remove(item);
	}
	
	private void atualizaItemNoFormulario() {
		item = new Item();
		produtoId = 0L;
	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
