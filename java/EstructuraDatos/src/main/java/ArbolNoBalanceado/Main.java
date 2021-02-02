package ArbolNoBalanceado;

public class Main {

	public static void main(String[] args) {
		Arbol arbol=new Arbol();
		arbol.agregarNodo(100);
		arbol.agregarNodo(50);
		arbol.agregarNodo(120);
		arbol.agregarNodo(200);
		arbol.agregarNodo(150);
		arbol.agregarNodo(80);
		
		System.out.println("Maximo: "+arbol.getMaximo());
		System.out.println("Minimo: "+arbol.getMinimo());
		System.out.println("----------- ");
		arbol.recorrerInOrden();
		System.out.println("\n----------- 700");
		System.out.println("Suma: "+arbol.getSuma());
		
	}

}
