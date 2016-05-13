package br.com.uberbeer.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.uberbeer.usuario.Usuario;

@SessionScoped
@Named
public class UsuarioLogado implements Serializable {

	private static final long serialVersionUID = 173266633307427002L;
	
	private Usuario usuario;

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogged() {
		return this.usuario != null;
	}
	
	public boolean isNotLogged() {
		return this.usuario == null;
	}
	
	public void logout() {
		this.usuario = null;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
}
