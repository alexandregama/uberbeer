package br.com.uberbeer.usuario;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class UsuarioBean {

	@Inject
	private UsuarioDao dao;
	
	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarios;
	
	public void salva() {
		if (usuario.getId() == null) {
			dao.salva(usuario);
		} else {
			dao.update(usuario);
		}
		usuario = new Usuario();
		usuarios = dao.listaTodos();
	}

	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			usuarios = dao.listaTodos();
		}
		return usuarios;
	}
	
	public void remove(Usuario usuario) {
		dao.remove(usuario);
		usuarios = dao.listaTodos();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
