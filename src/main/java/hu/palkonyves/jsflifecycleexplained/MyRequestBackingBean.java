package hu.palkonyves.jsflifecycleexplained;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class MyRequestBackingBean {

    public static final String CLASS_NAME = MyRequestBackingBean.class
	    .getSimpleName();

    private Boolean rendered = true;

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

}
