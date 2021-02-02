package ejemplos.lambda.ordenarNombre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ejemplos.lambda.Persona;

public class OrdenarListaSinLambda {
	
	/*
	 * Se utiliza una clase anonima para implementar al comparador
	 * */
	public static void ordenar(List<Persona> lista) {
		Collections.sort(lista,new Comparator<Persona>() {
			@Override
			public int compare(final Persona o1,final Persona o2) {
				return o1.getNombre().compareTo(o2.getNombre());
			}
		});
	}
	public static void main(String[] args) {
		List<Persona> lista =new ArrayList<>();
		lista.add(new Persona("Samuel","Polanco"));
		lista.add(new Persona("Naomi","Polanco"));
		lista.add(new Persona("Amadeus","Polanco"));
		System.out.println("Sin ordenar");
		for(Persona p : lista) {
			System.out.println(p.getNombre());
		}
		ordenar(lista);
		System.out.println("Ordenado");
		for(Persona p : lista) {
			System.out.println(p.getNombre());
		}
	}
}
