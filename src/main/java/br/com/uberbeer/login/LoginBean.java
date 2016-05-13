package br.com.uberbeer.login;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.uberbeer.usuario.Usuario;
import br.com.uberbeer.usuario.UsuarioDao;

@RequestScoped
@Named
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -4191526782439168707L;
	
	@Inject
	private UsuarioDao dao;
	
	@Inject
	private UsuarioLogado usuarioLogado;
	
	private Usuario usuario = new Usuario();
	
	public LoginBean() {
		System.out.println("LoginBean Constructor");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("LoginBean Criado!");
	}
	
	public String login() {
		boolean existeUsuario = dao.existe(usuario);
		if (existeUsuario) {
			usuarioLogado.loga(usuario);
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

	@PreDestroy
	public void destroy() {
		System.out.println("LoginBean sendo destruido!");
	}
}
