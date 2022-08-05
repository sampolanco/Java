package mx.sam.firstReactive.examples;

import java.util.ArrayList;
import java.util.List;

import mx.sam.firstReactive.model.Persona;
import reactor.core.publisher.Flux;

public class Filtrado {

	public void filter() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.filter(p->{
			return p.getId()>2;
		})
		.subscribe(p->{
			System.out.println("Reactor filter:" + p);
		});
	}
	
	public void distinct() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(1,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.distinct()
		.subscribe(p->{
			System.out.println("Reactor distinct:" + p);
		});
	}
	
	public void take() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.take(2)
		.subscribe(p->{
			System.out.println("Reactor take:" + p);
		});
	}
	public void takeLast() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.takeLast(2)
		.subscribe(p->{
			System.out.println("Reactor takeLast:" + p);
		});
	}
	public void skip() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.skip(2)
		.subscribe(p->{
			System.out.println("Reactor skip:" + p);
		});
	}
	
	public void skipLast() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.skipLast(2)
		.subscribe(p->{
			System.out.println("Reactor skipLast:" + p);
		});
	}
}
