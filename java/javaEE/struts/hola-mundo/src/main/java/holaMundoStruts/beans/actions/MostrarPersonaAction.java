package holaMundoStruts.beans.actions;

import com.opensymphony.xwork2.ActionSupport;

public class MostrarPersonaAction extends ActionSupport{
	private String nombre;
	private String password;
	
	public String execute() {
		System.out.println("Ejecutando MostrarPersonaAction->execute");
		return SUCCESS;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitulo() {
		return getText("persona.titulo");
	}
	public String getTextoNombre() {
		return getText("persona.textoNombre");
	}
	public String getValorBoton() {
		return getText("persona.valorBoton");
	}
	
}
