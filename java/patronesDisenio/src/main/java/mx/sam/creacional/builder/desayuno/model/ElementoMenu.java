package mx.sam.creacional.builder.desayuno.model;

import mx.sam.creacional.builder.desayuno.model.empaquetado.Empaquetado;

public class ElementoMenu {
	private String nombre;
	private double precio;
	private Empaquetado empaquetado;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Empaquetado getEmpaquetado() {
		return empaquetado;
	}
	public void setEmpaquetado(Empaquetado empaquetado) {
		this.empaquetado = empaquetado;
	}
	
	
}
