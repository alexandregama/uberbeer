package br.com.uberbeer.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

	public void remove(Usuario usuario) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		Usuario usuarioParaRemover = manager.find(Usuario.class, usuario.getId());
		manager.remove(usuarioParaRemover);
		manager.getTransaction().commit();
		manager.close();
	}

	public void update(Usuario usuario) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
		manager.close();
	}

	public boolean existe(Usuario usuario) {
		EntityManager manager = new JPAUtil().getEntityManager();
		String jpql = "select u from Usuario u where u.login = :login and u.senha = :senha";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		
		try {
			Usuario usuarioEncontrado = query.getSingleResult();
			
			return usuarioEncontrado != null;
		} catch (NoResultException e) {
			return false;
		}
	}

}
