package ejemplos.arrays;

import java.util.ArrayList;
import java.util.List;

public class MainArrays {

	public static void main(String ... args) {
		declararCadenas();
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
	public static void pindar2d(Object[][] cadena2d) {
		System.out.println("pintando cadena 2d");
		for(Object[] linea :cadena2d) {
			System.out.println("\tfila");

			for(Object valor :linea) {
				System.out.println("\t\t"+valor+ "_tipo:"+valor.getClass());
			}
		}
	}
}
