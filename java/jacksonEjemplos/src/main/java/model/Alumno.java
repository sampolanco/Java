package model;

public class Alumno {
	private String nombreAlumno;
	private int edadAlumno;
	private Escuela escuela;
	
	public Alumno() {
		nombreAlumno="sam";
		edadAlumno=26;
		Escuela escuela=new Escuela();
		escuela.setNombreEscuela("IPN");
		this.escuela=escuela;
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	public int getEdadAlumno() {
		return edadAlumno;
	}
	public void setEdadAlumno(int edadAlumno) {
		this.edadAlumno = edadAlumno;
	}
	public Escuela getEscuela() {
		return escuela;
	}
	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
	
	
}
