package holaMundoStruts.beans.actions;

import com.opensymphony.xwork2.ActionSupport;

import holaMundoStruts.model.Persona;

public class PersonaAction extends ActionSupport{

	private Persona persona;
	public String execute() {
		System.out.println("ejecutando PersonaAction->execute");
		return SUCCESS;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
