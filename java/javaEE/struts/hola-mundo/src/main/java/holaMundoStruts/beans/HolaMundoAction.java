package holaMundoStruts.beans;

public class HolaMundoAction {

	private String saludosAtr;

	public String execute() {
		System.out.println("Ejecutando HolaMundoAction->execute");
		this.saludosAtr="Saludos desde Struts";
		//Struts toma este string y lo procesa para saber que jsp se debe visualizar
		return "exito";
	}
	public String getSaludosAtr() {
		return saludosAtr;
	}

	public void setSaludosAtr(String saludosAtr) {
		this.saludosAtr = saludosAtr;
	}
	
	
}
