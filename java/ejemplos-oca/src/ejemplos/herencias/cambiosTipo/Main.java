package ejemplos.herencias.cambiosTipo;

import model.escuela.Maestro;
import model.escuela.Trabajador;

public class Main {
	
	public static void main(String... args) {
		Trabajador maestro=new Maestro();
		maestro.trabajar();
		((Maestro) maestro).setNombreMateria("Matematicas");
		maestro.trabajar();
	}
}
