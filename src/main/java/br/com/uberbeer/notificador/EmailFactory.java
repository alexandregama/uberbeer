package br.com.uberbeer.notificador;

import javax.enterprise.inject.Produces;

public class EmailFactory {

	@Produces @EmailContabilidade
	public String emailContabilidade = "contabilidade@uberbeer.com";
	
	@Produces @EmailFinanceiro
	public String emailFinanceiro = "financeiro@uberbeer.com";
	
}
