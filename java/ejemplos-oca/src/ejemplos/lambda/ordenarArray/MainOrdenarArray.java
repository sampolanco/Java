package ejemplos.lambda.ordenarArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.escuela.Alumno;

public class MainOrdenarArray {
	/*
	 * Se utiliza un lambda con clase anonima para implementar al comparador
	 * */
	public static void ordenar(List<Alumno> lista) {
		Collections.sort(lista, (Alumno p1, Alumno p2) -> p1.getNombre().compareTo(p2.getNombre()));
	}
	public static void main(String[] args) {
		List<Alumno> lista =new ArrayList<>();
		lista.add(new Alumno());
		lista.add(new Alumno());
		lista.add(new Alumno());
		System.out.println("Sin ordenar");
		for(Alumno p : lista) {
			System.out.println(p.getNombre());
		}
		ordenar(lista);
		System.out.println("Ordenado");
		for(Alumno p : lista) {
			System.out.println(p.getNombre());
		}
	}
}
