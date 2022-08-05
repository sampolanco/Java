package mx.sam.firstReactive.examples;

import java.util.ArrayList;
import java.util.List;

import mx.sam.firstReactive.model.Persona;
import reactor.core.publisher.Flux;

public class Merge {

	public void merge() {

		List<Persona> personas=new ArrayList<>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		
		List<Integer> listaInteger=new ArrayList<>();
		listaInteger.add(100);
		listaInteger.add(200);

		Flux<Persona> fluxPersonas=Flux.fromIterable(personas);
		Flux<Integer> fluxInteger=Flux.fromIterable(listaInteger);
		
		Flux.merge(fluxPersonas,fluxInteger)
		.subscribe(p->{
			System.out.println("Reactor merge:" + p);
		});
	}
}
