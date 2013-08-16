package hu.palkonyves.jsflifecycleexplained;

import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "MyValidator")
public class MyValidator implements Validator {

    public static final String CLASS_NAME = MyValidator.class.getSimpleName();

    @PostConstruct
    public void postConstruct() {
	PhaseLogger.print(CLASS_NAME + "@PostConstruct", this, "");
    }

    @Override
    public void validate(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException {
	PhaseLogger.print(CLASS_NAME + ".validate()", component, "");
    }

}
