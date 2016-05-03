package br.com.uberbeer.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.uberbeer.usuario.Usuario;
import br.com.uberbeer.usuario.UsuarioDao;

@SessionScoped
@Named
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -4191526782439168707L;
	
	@Inject
	private UsuarioDao dao;
	
	public LoginBean() {
	}
	
	private Usuario usuario = new Usuario();
	
	public String login() {
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
