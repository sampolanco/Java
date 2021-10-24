package holaMundoStruts.beans.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction  extends ActionSupport{
	private String usuario;
	private String password;
	
	public String execute() {
		System.out.println("Usuario "+usuario+" ejecutando LoginAction->execute");
		if("sam".equals(usuario))
			return SUCCESS;
		else
			return INPUT;
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
