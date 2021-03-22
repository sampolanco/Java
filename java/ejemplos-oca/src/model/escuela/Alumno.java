package model.escuela;

public class Alumno {
	private String nombre;
	private Integer edad;
	private static int datoEstatico=10;
	public Alumno() {

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
