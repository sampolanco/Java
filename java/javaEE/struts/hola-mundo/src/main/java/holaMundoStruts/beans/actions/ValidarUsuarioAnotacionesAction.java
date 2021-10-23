package holaMundoStruts.beans.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results({ 
		@Result(name = "success", location = "/WEB-INF/content/bienvenido.jsp"),
		@Result(name = "input", location = "/WEB-INF/content/login-anotaciones.jsp"),
		//@Result(name = "input", location = "loginAnotaciones", type = "redirectAction"), 
	})
public class ValidarUsuarioAnotacionesAction extends ActionSupport {
	private String usuario;
	private String password;

	@Action("validarUsuarioAnotaciones")
	public String execute() {
		System.out.println("Usuario " + usuario + " ejecutando ValidarUsuarioAnotacionesAction->execute");
		if ("sam".equals(usuario)) {
			addActionMessage(getText("usuario.valido"));
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	@Override
	public void validate() {
		if(this.usuario==null || "".equals(this.usuario.trim())) {
			addFieldError("usuario", getText("usuario.novacio"));
		}
		else if(!"sam".equals(usuario)) {
			addActionError(getText("usuario.novalido"));
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
