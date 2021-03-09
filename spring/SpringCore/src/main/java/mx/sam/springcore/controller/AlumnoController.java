package mx.sam.springcore.controller;

import mx.sam.springcore.beans.AlumnoBean;

public class AlumnoController {
	public boolean guardarAlumno(AlumnoBean alumno) {
		System.out.println("AlumnoController -> Guardando Alumno");
		return true;
	}
}
