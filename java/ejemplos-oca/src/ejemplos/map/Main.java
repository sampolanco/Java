package ejemplos.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.lang.System.out;

import model.escuela.Alumno;


public class Main {

	private void imprimirV7(Map<Integer,Alumno> mapa) {
		for(Entry<Integer, Alumno> entrada:mapa.entrySet()) {
			out.println(entrada.getValue().getNombre());
		}
	}
	private void imprimir(Map<Integer,Alumno> mapa) {
		mapa.forEach((key,value)->out.println(value.getNombre()));
		/*mapa.entrySet()
			.stream()
			.forEach(out::println);*/
	}
	
	private void putIfAbsent(Map<Integer,Alumno> mapa) {
		//mapa.put(4,new Persona("Alejandra","Juarez"));
		mapa.putIfAbsent(4,new Alumno());
		imprimir(mapa);
	}
	private void computeIfPresent(Map<Integer,Alumno> mapa) {
		mapa.computeIfPresent(3, (key,value)->new Alumno());
		imprimir(mapa);
	}
	private void getOrDefault(Map<Integer,Alumno> mapa) {
		Alumno persona=mapa.getOrDefault(3,new Alumno());
		out.println(persona.getNombre());
	}
	private void collect(Map<Integer,Alumno> mapa) {
		Map<Integer,Alumno> colectado=mapa
				.entrySet()
				.stream()
				.filter(elemento->elemento.getValue().getNombre().contains("Rodriguez"))
				.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
		imprimir(colectado);
	}
	public static void main(String[] args) {
		Main main=new Main();
		Map<Integer,Alumno> mapa= new HashMap<>();
		mapa.put(1,new Alumno());
		mapa.put(1,new Alumno());		
		mapa.put(1,new Alumno());
		mapa.put(1,new Alumno());
		
		out.println("Imprimir V7");
		main.imprimirV7(mapa);
		out.println("\nImprimir");
		main.imprimir(mapa);
		out.println("\nPutIfAbsent");
		main.putIfAbsent(mapa);
		out.println("\nComputeIfPresent");
		main.computeIfPresent(mapa);
		out.println("\nGetOrDefault");
		main.getOrDefault(mapa);
		out.println("\nCollect");
		main.collect(mapa);
	}
}
