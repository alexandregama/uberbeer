package br.com.uberbeer.autenticacao;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.uberbeer.login.UsuarioLogado;

public class AutorizadorDeUsuario implements PhaseListener {

	private static final long serialVersionUID = 8559577605936034562L;
	
	@Inject
	private UsuarioLogado usuarioLogado;

	@Override
	public void beforePhase(PhaseEvent event) {
	}
	
	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("Autorizador - AfterPhase");
		FacesContext context = event.getFacesContext();
		
		String paginaVisitada = context.getViewRoot().getViewId();
		if (paginaVisitada.equals("/login.xhtml")) {
			return;
		}
		if (usuarioLogado.isNotLogged()) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
	}
	
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
}
