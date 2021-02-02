package ejemplos.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.lang.System.out;


import ejemplos.lambda.Persona;


public class Main {

	private void imprimirV7(Map<Integer,Persona> mapa) {
		for(Entry<Integer, Persona> entrada:mapa.entrySet()) {
			out.println(entrada.getValue().getNombre());
		}
	}
	private void imprimir(Map<Integer,Persona> mapa) {
		mapa.forEach((key,value)->out.println(value.getNombre()));
		/*mapa.entrySet()
			.stream()
			.forEach(out::println);*/
	}
	
	private void putIfAbsent(Map<Integer,Persona> mapa) {
		//mapa.put(4,new Persona("Alejandra","Juarez"));
		mapa.putIfAbsent(4,new Persona("Alejandra","Juarez"));
		imprimir(mapa);
	}
	private void computeIfPresent(Map<Integer,Persona> mapa) {
		mapa.computeIfPresent(3, (key,value)->new Persona("ComputeIfPresent","Apellido"));
		imprimir(mapa);
	}
	private void getOrDefault(Map<Integer,Persona> mapa) {
		Persona persona=mapa.getOrDefault(3,new Persona("Default","Apellido"));
		out.println(persona.getNombre());
	}
	private void collect(Map<Integer,Persona> mapa) {
		Map<Integer,Persona> colectado=mapa
				.entrySet()
				.stream()
				.filter(elemento->elemento.getValue().getApellido().contains("Rodriguez"))
				.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
		imprimir(colectado);
	}
	public static void main(String[] args) {
		Main main=new Main();
		Map<Integer,Persona> mapa= new HashMap<>();
		mapa.put(1,new Persona("Naomi","Polanco"));
		mapa.put(2,new Persona("Amadeus","Polanco"));
		mapa.put(3,new Persona("Samuel Antonio","Polanco"));
		mapa.put(4,new Persona("Aurora","Rodriguez"));
		
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
