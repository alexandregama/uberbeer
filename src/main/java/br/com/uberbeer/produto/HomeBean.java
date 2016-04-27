package br.com.uberbeer.produto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeBean {

	private String name = "Gama";
	
	public HomeBean() {
		System.out.println("Bean iniciado");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
