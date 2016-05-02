package br.com.uberbeer.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.uberbeer.usuario.Usuario;
import br.com.uberbeer.usuario.UsuarioDao;

@RequestScoped
@ManagedBean
public class LoginBean {

	private Usuario usuario = new Usuario();
	
	public void login() {
		UsuarioDao dao = new UsuarioDao();
		boolean existeUsuario = dao.existe(usuario);
		System.out.println("Existe?: " + existeUsuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
