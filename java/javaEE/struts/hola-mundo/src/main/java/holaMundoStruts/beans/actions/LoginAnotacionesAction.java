package holaMundoStruts.beans.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Result(name = "success",location="/WEB-INF/content/login-anotaciones.jsp")
public class LoginAnotacionesAction extends ActionSupport {

	@Action("loginAnotaciones")
	public String execute() {
		System.out.println("ejecutando LoginAnotacionesAction->execute");
		return SUCCESS;
	}

}
