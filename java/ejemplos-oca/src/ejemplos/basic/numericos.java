package ejemplos.basic;

public class numericos {

	/*
	 * Cuando se evaluan numeros al valor a asignar no le importa en donde se va a guardar
	 * si se requiere asignar a una variable en especifico. Se tienen que cumplir las condiciones
	 * en el calculo
	 * */
	private static void evaluarOperacionEntero() {
		System.out.println("evaluarOperacionEntero");
		int x=10;
		double resultado=x/3;
		System.out.println("evaluarOperacionEntero parte 1="+resultado);
		double resultado2=x/3D;
		System.out.println("evaluarOperacionEntero parte 2="+resultado2);
		double resultado3=((double)x)/3;
		System.out.println("evaluarOperacionEntero parte 3="+resultado3);
	}
	
	/*
	 * PosIncremento: Primero se asigna y despues se incrementa
	 * PreImcremento: Primero se incrementa y despues se asigna
	 * */
	private static void evaluarIncremento() {
		System.out.println("evaluarIncremento");
		int x=10;
		int y=x++;
		int z=10;
		int w=++z;
		System.out.println("Resultado de y=x++="+y);
		System.out.println("Resultado de w=++z="+w);
	}
	/*
	 * En el operador ternario debe haber una asignacion
	 * */
	private static void operadorTernario() {
		System.out.println("operadorTernario");

		int x=10;
		boolean w=true;
		w=(x==0)?false:++x==11 && x++==11;
		System.out.println("Resultado de x="+x);
		System.out.println("Resultado de w="+w);
		
		int y=0;
		int z=(y==0)?y++:++y;
		System.out.println("Resultado de z="+z);
		
	}
	
	public static void main(String[] args) {
		evaluarOperacionEntero();
		evaluarIncremento();
		operadorTernario();
	}

}
