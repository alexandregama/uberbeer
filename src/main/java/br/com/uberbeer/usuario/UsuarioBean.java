package br.com.uberbeer.usuario;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarios;
	
	public void salva() {
		UsuarioDao dao = new UsuarioDao();
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
			UsuarioDao dao = new UsuarioDao();
			usuarios = dao.listaTodos();
		}
		return usuarios;
	}
	
	public void remove(Usuario usuario) {
		UsuarioDao dao = new UsuarioDao();
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
