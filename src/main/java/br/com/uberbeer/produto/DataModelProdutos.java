package br.com.uberbeer.produto;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

public class DataModelProdutos extends LazyDataModel<Produto> {

	private static final long serialVersionUID = 2514922522427867588L;

	@Inject
	private ProdutoDao dao;
	
	@PostConstruct
	public void setRows() {
		int total = dao.totalDeProdutos();
		System.out.println(total);
		this.setRowCount(total);
	}
	
	@Override
	public List<Produto> load(int inicio, int fim, List<SortMeta> ordenacao, Map<String, Object> filtros) {
		return dao.listaPaginado(inicio, fim);
	}
	
}
