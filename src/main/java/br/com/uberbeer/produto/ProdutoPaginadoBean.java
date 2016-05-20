package br.com.uberbeer.produto;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ProdutoPaginadoBean implements Serializable {

	private static final long serialVersionUID = 198122113579973701L;

	@Inject
	private DataModelProdutos dataModel;

	public DataModelProdutos getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModelProdutos dataModel) {
		this.dataModel = dataModel;
	}
}
