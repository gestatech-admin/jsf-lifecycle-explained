package hu.palkonyves.jsflifecycleexplained;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Lifecycle phase listener catching changes between every JSF lifecycle.
 * <p>
 * {@link #event(javax.faces.event.ComponentSystemEvent)} catches every
 * component phase event, that is registered for components in the view tree.
 * 
 * @author Pali
 * 
 */
@ManagedBean
public class MyPhaseListener implements PhaseListener {

    private static final long serialVersionUID = 1L;

    public static final String CLASS_NAME = MyPhaseListener.class
	    .getSimpleName();

    @PostConstruct
    public void postConstruct() {
	PhaseLogger.print(CLASS_NAME + "@PostConstruct", this, "");
    }

    @Override
    public void afterPhase(PhaseEvent event) {
	PhaseLogger.afterEvent(event);
	if (event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
	    PhaseLogger.messages.clear();
	}
    }

    @Override
    public void beforePhase(PhaseEvent event) {
	PhaseLogger.beforeEvent(event);
    }

    @Override
    public PhaseId getPhaseId() {
	return PhaseId.ANY_PHASE;
    }

    public void event(javax.faces.event.ComponentSystemEvent event)
	    throws AbortProcessingException {
	Object source = event.getSource();
	UIComponent component = event.getComponent();
	PhaseLogger.print(event, source, component, "");
    }
}
