package hu.palkonyves.jsflifecycleexplained;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

/**
 * This managed bean collects debug messages about JSF and component lifecycle
 * events.
 * 
 * <p>
 * This class is not thread safe
 * 
 * @author Pali
 * 
 */
@ManagedBean
public class PhaseLogger {

    public static final String TYPE_LIFECYCLE = "redColor";
    public static final String TYPE_COMPONENT_EVENT = "yellowColor";
    public static final String TYPE_APPLICATION = "greenColor";

    public static class DebugMessage {

	String event;
	String source;
	String component;
	String details;
	String type;

	public String getEvent() {
	    return event;
	}

	public String getSource() {
	    return source;
	}

	public String getComponent() {
	    return component;
	}

	public String getDetails() {
	    return details;
	}
    }

    static ArrayList<DebugMessage> messages = new ArrayList<DebugMessage>();

    public static void print(String phase, Object component, String more) {
	DebugMessage message = new DebugMessage();
	message.event = phase;
	message.component = getObjectString(component);
	message.source = null;
	message.details = more;
	message.type = TYPE_APPLICATION;

	messages.add(message);
    }

    public static void print(Object phase, Object source, Object component,
	    String more) {
	DebugMessage message = new DebugMessage();
	message.event = phase.getClass().getSimpleName();
	message.source = getObjectString(source);
	message.component = getObjectString(component);
	message.details = more;
	message.type = TYPE_COMPONENT_EVENT;

	messages.add(message);
    }

    public static void beforeEvent(PhaseEvent event) {
	onEvent(event, "BEFORE");
    }

    public static void afterEvent(PhaseEvent event) {
	onEvent(event, "AFTER");
    }

    private static void onEvent(PhaseEvent event, String prefix) {
	PhaseId phase = event.getPhaseId();
	Object source = event.getSource();

	DebugMessage message = new DebugMessage();
	message.event = prefix + " " + phase;
	message.source = getObjectString(source);
	message.component = null;
	message.details = null;
	message.type = TYPE_LIFECYCLE;

	messages.add(message);
    }

    private static String getObjectString(Object obj) {
	return "" + obj.getClass().getSimpleName() + "@"
		+ Integer.toHexString(System.identityHashCode(obj));
    }

    public List<DebugMessage> getLog() {
	return messages;
    }

    public String getRowStyle() {
	StringBuilder builder = new StringBuilder();
	for (DebugMessage message : messages) {
	    builder.append(message.type).append(",");
	}

	builder.deleteCharAt(builder.length() - 1);
	return builder.toString();
    }
}
