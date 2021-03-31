package ejemplos.metodos;
import static java.lang.Math.*;
public class MainMetodos {
	static private int variableMedoto;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={1,2,3};
		metodoVarArgs(new int[] {1,2,3});
		short datoShort=2;
		byte datoByte=2;
		//metodoint(2,datoShort);
		metodoSobrecargado(datoByte);
		metodoSobrecargado(new Integer(datoByte));
		//final
		final int c;
		c=20;
		//Estatico
		double x=PI;
	}
	
	static int metodoAlcanceDefault() {
		if(true)
			return 1;
		else
			return 0;
	}
	static private void metodoVarArgs(int... valores) {
		for(int valor: valores)
			System.out.print(valor+", ");
	}
	private static void metodoSobrecargado(long valor) {
		System.out.print("long_"+valor);
	}
	private static void metodoSobrecargado(Integer valor) {
		System.out.print("Integer_"+valor);
	}
	private static void metodointShort(int valor,Short s) {
			System.out.print("int_"+valor);
	}
	private static void metodointShort(Integer valor, short s) {
		System.out.print("Integer_"+valor);
	}
}
