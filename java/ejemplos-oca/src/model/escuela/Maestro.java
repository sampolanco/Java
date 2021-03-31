package model.escuela;

public class Maestro extends Trabajador{
	private String nombreMateria;
	
	public Maestro() {
		this("nombre materia default");
	}
	public Maestro(String nombreMateria) {
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
