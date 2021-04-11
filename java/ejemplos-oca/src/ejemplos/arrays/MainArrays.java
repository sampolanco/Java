package ejemplos.arrays;

import java.util.ArrayList;
import java.util.List;

import model.escuela.Escuela;

public class MainArrays {

	public static void main(String ... args) {
		declararCadenas();
		clonado();
		
		Object [] x = new Integer[]{50, 50};
		x[0]=10;
		System.out.print(x[0]);
		
		 //double [] arr = new int[2]; //Error de compilacion
	}
	public static void declararCadenas() {
		List<String> lista= new ArrayList<String>();
		lista.add("hola");
		
		int [] cadena,cadena2d [];
		int[] cadenaDeclaracion2= {2,3};
		int[] cadenaDeclaracion3= new int[]{2,3};

		int[][] cadena2dDeclaracion2= {{1,2,3,4},{11,22}};
		Object[][] cadena2dObject= {{1,2,3l,4f},{cadenaDeclaracion2,lista,"valor",11,22,1.123}};

		pindar2d(cadena2dObject);
	}
	public static void clonado() {
		Escuela escuela=new Escuela();
		escuela.setNombre("nombre 1");
		Object cadenadObject[]= {1,escuela};
		Object cadenadObject2[]=cadenadObject.clone();
		((Escuela) cadenadObject2[1]).setNombre("nombre cambiado");
		
		System.out.println(escuela.getNombre());
	}
	public static void pindar2d(Object[][] cadena2d) {
		System.out.println("pintando cadena 2d");
		for(Object[] linea :cadena2d) {
			System.out.println("\tfila de lingitud "+linea.length);

			for(Object valor :linea) {
				System.out.println("\t\t"+valor+ "_tipo:"+valor.getClass());
			}
		}
	}
}
