package holaMundoStruts.beans.actions;

public class SaludosConvencionAction {

	private String saludosAtr;

	public String execute() {
		System.out.println("Ejecutando SaludosConvencionAction->execute");
		this.saludosAtr="Saludos desde Struts con convencion";
		return "exito";
	}
	public String getSaludosAtr() {
		return saludosAtr;
	}

	public void setSaludosAtr(String saludosAtr) {
		this.saludosAtr = saludosAtr;
	}
	
	
}
