package model.escuela;

public class Maestro extends Trabajador{
	private String nombreMateria;
	
	public Maestro() {
	}
	
	@Override
	public void trabajar() {
		System.out.println("Trabajo como maestro en la materia "+ nombreMateria);
	}
	
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
}
