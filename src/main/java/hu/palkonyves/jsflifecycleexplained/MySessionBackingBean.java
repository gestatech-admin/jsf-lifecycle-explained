package hu.palkonyves.jsflifecycleexplained;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@RequestScoped
@ManagedBean
public class MySessionBackingBean {

    public static final String CLASS_NAME = MySessionBackingBean.class
	    .getSimpleName();

    private Boolean rendered = true;
    private String text = "text";

    @PostConstruct
    public void postConstruct() {
	PhaseLogger.print(CLASS_NAME + "@PostConstruct", this, "");
    }

    public Boolean getRendered() {
	PhaseLogger.print(CLASS_NAME + ".getRendered()", this, "");
	return rendered;
    }

    public void setRendered(Boolean rendered) {
	PhaseLogger.print(CLASS_NAME + ".setRendered()", this, "");
	this.rendered = rendered;
    }

    public String getText() {
	PhaseLogger.print(CLASS_NAME + ".getText()", this, "");
	return text;
    }

    public void setText(String text) {
	PhaseLogger.print(CLASS_NAME + ".setText()", this, "");
	this.text = text;
    }

    public void action() {
	PhaseLogger.print(CLASS_NAME + ".action()", this, "");
    }

    public void actionListener(ActionEvent event) {
	UIComponent c = event.getComponent();
	PhaseLogger.print(CLASS_NAME + ".getText()", c, "");
    }

    public void textValueChangeListener(ValueChangeEvent event) {
	PhaseLogger.print(CLASS_NAME + ".textValueChangeListener()",
		event.getComponent(), "");
    }
}
