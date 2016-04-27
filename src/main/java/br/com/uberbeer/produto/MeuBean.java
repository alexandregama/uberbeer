package br.com.uberbeer.produto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MeuBean {

	private String name = "Gama";
	
	public MeuBean() {
		System.out.println("Bean iniciado");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
