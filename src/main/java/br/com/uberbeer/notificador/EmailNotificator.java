package br.com.uberbeer.notificador;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import br.com.uberbeer.produto.ProdutoEvent;

public class EmailNotificator {

	@Inject @EmailContabilidade
	private String emailContabilidade;
	
	@Inject @EmailFinanceiro
	private String emailFinanceiro;
	
	@Inject @Any
	private Instance<String> todosOsEmails;
	
	public void notifica(@Observes ProdutoEvent event) {
		System.out.println("Produto atualizado: " + event.getProduto());
		System.out.println("Notifica contabilidade pelo email " + emailContabilidade);
		System.out.println("Notifica financeiro pelo email " + emailFinanceiro);
	}
	
	public void notificaTodos(@Observes ProdutoEvent event) {
		System.out.println("Produto atualizado: " + event.getProduto());
		todosOsEmails.forEach(email -> System.out.println(email));
	}
	
}
