package mx.sam.firstReactive.model;

import java.util.Objects;

public class Persona {
	private Integer id;
	private String nombre;
	private Integer edad;
	
	public Persona() {
		
	}
	public Persona(Integer id,String nombre, Integer edad) {
		this.id=id;
		this.nombre=nombre;
		this.edad=edad;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Persona [id="+id + " nombre=" + nombre + ", edad=" + edad + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(id, other.id);
	}
	

}
