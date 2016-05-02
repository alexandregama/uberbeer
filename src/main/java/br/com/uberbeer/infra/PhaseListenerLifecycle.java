package br.com.uberbeer.infra;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseListenerLifecycle implements PhaseListener {

	private static final long serialVersionUID = -14700159933564033L;

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Before Phase: " + event.getPhaseId());
	}
	
	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("After Phase: " + event.getPhaseId());
	}
	
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
	
}
