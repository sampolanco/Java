package ejemplos.funcionesAltoOrden;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.out;

public class Main {
	private Function<String,String> convertirMayusculas=x->x.toUpperCase();
	private Function<String,String> convertirMinusculas=x->x.toLowerCase();
	
	/*
	 * Metodo que recibe una Function
	 * Function: Interface funcional generica de java que tiene como metodo apply
	 * */
	public void imprimir(Function<String,String> funcion,String mensaje) {
		out.println(funcion.apply(mensaje));
	}
	
	/*
	 * Metodo que recibe un string y retorna una funcion lambda
	 * a la cual se le realiza la operacion indicada (recibe String y regresa String)
	 * */
	public Function<String,String> concatenar(String mensaje) {
		return x-> mensaje+" "+x;
	}
	
	/*
	 * 
	 * */
	public void filtrar(List<Persona> lista,Consumer<Persona> consumer) {
		lista.stream()
			.filter(filtroContains("Sam"))
			.forEach(consumer);
	}
	public Predicate<Persona> filtroContains(String texto){
		return x-> x.getNombre().contains(texto);
	}
	
	public static void main(String[] args) {
		Main main=new Main();
		main.imprimir(main.convertirMayusculas,"Samuel");
		out.println(main.concatenar("Samuel").apply("Concatenado"));
		
		List<Persona> lista =new ArrayList<>();
		lista.add(new Persona("Samuel","Polanco"));
		lista.add(new Persona("Naomi","Polanco"));
		lista.add(new Persona("Amadeus","Polanco"));
		lista.add(new Persona("Samuel Antonio","Polanco"));
		lista.add(new Persona("Aurora","Rodriguez"));
		
		main.filtrar(lista, x->out.println(x.getNombre()));
	}

}
