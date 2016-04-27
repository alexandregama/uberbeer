package uberbeer;

import javax.inject.Named;

@Named
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
