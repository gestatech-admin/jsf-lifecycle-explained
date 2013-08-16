package hu.palkonyves.jsflifecycleexplained;

import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("MyConverter")
public class MyConverter implements Converter {

    public static final String CLASS_NAME = MyConverter.class.getSimpleName();

    @PostConstruct
    public void postConstruct() {
	PhaseLogger.print(CLASS_NAME + "@PostConstruct", this, "");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
	    String value) {
	PhaseLogger.print(CLASS_NAME + ".getAsObject()", component, "");
	return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
	    Object value) {
	PhaseLogger.print(CLASS_NAME + ".getAsString()", component, "");
	return value.toString();
    }

}
