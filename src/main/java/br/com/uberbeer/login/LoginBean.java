package br.com.uberbeer.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.uberbeer.usuario.Usuario;
import br.com.uberbeer.usuario.UsuarioDao;

@SessionScoped
@ManagedBean
public class LoginBean {

	private Usuario usuario = new Usuario();
	
	public String login() {
		UsuarioDao dao = new UsuarioDao();
		boolean existeUsuario = dao.existe(usuario);
		if (existeUsuario) {
			return "produtos?faces-redirect=true";
		}
		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
