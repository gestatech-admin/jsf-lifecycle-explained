package hu.palkonyves.jsflifecycleexplained;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

@SessionScoped
@ManagedBean
public class MyAjaxSessionBackingBean {

    private Boolean rendered = true;
    private String text = "text";
    private String number = "nummber";

    private static final String CLASS_NAME = MyAjaxSessionBackingBean.class
	    .getSimpleName();

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
	PhaseLogger.print(CLASS_NAME + ".actionListener()", c, "");
    }

    public void actionAjaxListener(AjaxBehaviorEvent event) {
	PhaseLogger.print(CLASS_NAME + ".actionAjaxListener()",
		event.getComponent(), "");
    }

    public void numberAjaxListener(AjaxBehaviorEvent event) {
	PhaseLogger.print(CLASS_NAME + ".numberAjaxListener()",
		event.getComponent(), "");
    }

    public void textAjaxListener(AjaxBehaviorEvent event) {
	PhaseLogger.print(CLASS_NAME + ".textAjaxListener()",
		event.getComponent(), "");
    }

    public void textValueChangeListener(ValueChangeEvent event) {
	PhaseLogger.print(CLASS_NAME + ".textValueChangeListener()",
		event.getComponent(), "");
    }

    public void numberValueChangeListener(ValueChangeEvent event) {
	PhaseLogger.print(CLASS_NAME + ".numberValueChangeListener()",
		event.getComponent(), "");
    }

    public String getNumber() {
	PhaseLogger.print(CLASS_NAME + ".getNumber()", this, "");
	return number;
    }

    public void setNumber(String number) {
	PhaseLogger.print(CLASS_NAME + ".setNumber()", this, "");
	this.number = number;
    }
}
