package model.escuela;

import model.escuela.subpaquete.Libro;

public class Alumno {
	private String nombre;
	private Integer edad;
	private static int datoEstatico=10;
	private Libro libro;
	
	public String variablePublica;
	String variableDefault;
	protected int variableProtected;
	private float variablePrivate;
	
	public Alumno() {
		//libro=new Libro();
		//libro.nombre="Don quijote";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
}
