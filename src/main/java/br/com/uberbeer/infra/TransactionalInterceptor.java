package br.com.uberbeer.infra;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transactional
public class TransactionalInterceptor {

	@Inject
	private EntityManager manager;
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		manager.getTransaction().begin();
		
		Object resultado = ctx.proceed();
		
		manager.getTransaction().commit();
		
		return resultado;
	}
	
}
