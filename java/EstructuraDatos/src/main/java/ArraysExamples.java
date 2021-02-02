import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysExamples {

	private static void array() {
		Integer[] arregloEnteros=new Integer[]{1,2};
		Object[] arregloObjetos=new Integer[]{1,2};
		Object[] arregloObjetos2=new Object[]{new Integer(1),"2"};
		
		System.out.println(arregloObjetos2[0]+ "_" +arregloObjetos2[1]);
	}
	private static void list() {
		List<String> arreglo=new ArrayList();
		arreglo.add("Samuel");
		arreglo.add("Naomi");
		arreglo.add(0, "Amadeus");
		List<Integer> arregloEnteros=Arrays.asList(new Integer[]{1,2});
		List<Object> arregloObjetos=Arrays.asList(new Object[]{1,2});
		List<Object> arregloObjetos2=Arrays.asList(new Object[]{new Integer(1),"2"});
		
		System.out.println(arregloObjetos2.get(0)+ "_" +arregloObjetos2.get(1));
	}
	
	private static int[] reverse(int[] lista) {
		int longitud=lista.length;
		int[] listaNueva=new int[longitud];
		for(int i=(longitud-1);i>=0;i--) 
			listaNueva[longitud-i-1]=lista[i];
		return listaNueva;
	}
	private static ArrayList<Integer> reverseArrayList(ArrayList<Integer> lista) {
		int longitud=lista.size();		
		ArrayList<Integer> listaNueva=new ArrayList<Integer>();
		for(int i=(longitud-1);i>=0;i--) 
			listaNueva.add(lista.get(i));
		return listaNueva;
	}
	
	private static void reverseImproved(int[] lista) {
		int inicio=0;
		int fin=lista.length-1;
		while (inicio<fin) {
			int aux=lista[fin];
			lista[fin]=lista[inicio];
			lista[inicio]=aux;
			inicio++;
			fin--;
		}
	}
	private static void reverseArrayListImproved(ArrayList<Integer> lista) {
		int inicio=0;
		int fin=lista.size()-1;
		while (inicio<fin) {
			Integer aux=lista.get(fin);
			lista.set(fin, lista.get(inicio));
			lista.set(inicio, aux);
			inicio++;
			fin--;
		}
	}
	private static boolean isPalindromo(String texto) {
		char[] textoChar=texto.toCharArray();
		int inicio=0;
		int fin=textoChar.length-1;
		while (inicio<fin) {
			if(textoChar[fin]!=textoChar[inicio])
				return false;
			inicio++;
			fin--;
		}
		return true;
	}
	private static boolean isAnagrama(String texto1,String texto2) {
		char[] texto1Char=texto1.toCharArray();
		char[] texto2Char=texto2.toCharArray();
		if(texto1Char.length!=texto2Char.length)
			return false;
		Arrays.sort(texto1Char);
		Arrays.sort(texto2Char);
		for(int i=0;i<texto1Char.length-1;i++) {
			if(texto1Char[i]!=texto2Char[i])
				return false;
		}
		return true;
	}
	//Cada elemento del arreglo es menor que la longitud del arreglo O(Nlog(N))
	private static boolean findDuplicates(int[] arreglo) {
		Arrays.sort(arreglo);
		int largo=arreglo.length;
		return arreglo[largo-1]==largo;
	}
	//Cada elemento del arreglo es menor que la longitud del arreglo O(N)
	//Solo funciona para numeros positivos
	//Otra forma es ir al indice que marca el numero. 
	//Guardar el numero para el siguiente saldo.
	//Una vez en el indice cambiar de signo el numero y ir al numero siguiente.
	//Si ya se pasó por el numero (Es negativo) hay repetidos
	private static boolean findDuplicatesOptimized(int[] arreglo) {
		int suma=0;
		int largo=arreglo.length;
		for(int elemento:arreglo)
			suma+=elemento;
		//Si no hay duplicados y cada elemento es menor que el arreglo suma=largo*(largo+1)/2
		int sumaCalc=largo*(largo+1)/2;
		return suma==sumaCalc;
	}
	
	public static void main(String[] args) {
		//array();
		//list();
		int[] lista =new int[] {1,2,3,4,5};
		ArrayList<Integer> listaArray=new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
		
		reverseImproved(lista);
		for(int x : lista) 
			System.out.println(x);
		
		reverseArrayListImproved(listaArray);
		for(int x : listaArray) 
			System.out.println(x);
		
		System.out.println("casa es palindromo:" +isPalindromo("casa"));
		System.out.println("sam es palindromo:" +isPalindromo("sam"));
		System.out.println("oso es palindromo:" +isPalindromo("oso"));
		System.out.println("anna es palindromo:" +isPalindromo("anna"));
		System.out.println("amor y roma son anagramas:" +isAnagrama("amor","roma"));
		System.out.println("samuel y manuel son anagramas:" +isAnagrama("samuel","manuel"));
		System.out.println("Duplicados en {1,2,3,4,5,2}" +!findDuplicatesOptimized(new int[]{1,2,3,4,5,6}));
	}

}
