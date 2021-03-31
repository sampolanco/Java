package ejemplos.bloques;

import model.escuela.Alumno;

public class ClaseX {
	static final Integer datoInteger;
	int atributo1;
	static {
		datoInteger=10;
		int variableBloque=12;
		System.out.println("metodo de bloque estatico ClaseX");
		metodoEstatico();
	}
	{
		atributo1=10;
		atributo2=20;
		Alumno objeto1=new Alumno();
		objeto1.setEdad(1);
		System.out.println("metodo de bloque ClaseX");
	}
	{
		
	}
	int atributo2;
	
	private static void metodoEstatico() {
		System.out.println("metodo estatico");
	}

	protected ClaseX(){
		System.out.println("metodo de constructor ClaseX");
	}
}
