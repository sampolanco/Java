package paquete.model;

public class Escuela {
	private String nombre;

	public Escuela(){}
	public Escuela(String nombre){
		this.nombre=nombre;
	}

	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
}
