package br.com.uberbeer.notafiscal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class NotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "cnpj", length = 15)
	private String cnpj;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data")
	private Calendar data = Calendar.getInstance();
	
	@OneToMany
	private List<Item> itens = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void adiciona(Item item) {
		this.itens.add(item);
	}

	public void remove(Item item) {
		Optional<Item> itemParaRemover = itens.stream().filter(i -> i.getProduto().equals(item.getProduto())).findFirst();
		if (itemParaRemover.isPresent()) {
			itens.remove(itemParaRemover.get());
		}
	}
}
