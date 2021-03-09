package mx.sam.springcore.service;

import mx.sam.springcore.beans.AlumnoBean;

public class AlumnoService {
	public boolean guardarAlumno(AlumnoBean alumno) {
		System.out.println("AlumnoService -> Guardando Alumno");
		return true;
	}
}
