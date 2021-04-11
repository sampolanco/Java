package model.escuela;

public class Trabajador {
	private String nombre;
	private Escuela escuela;

	public Trabajador() {
	}
	public Trabajador(String nombre) {
		this.nombre=nombre;
	}
	
	public void trabajar() {
		System.out.println("Trabajo genericamente como trabajador");
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Escuela getEscuela() {
		return escuela;
	}
	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
	
	
}
