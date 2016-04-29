package br.com.uberbeer.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.uberbeer.infra.JPAUtil;

public class UsuarioDao {

	public void salva(Usuario usuario) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		manager.close();
	}

	public List<Usuario> listaTodos() {
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u", Usuario.class);
		return query.getResultList();
	}

}
