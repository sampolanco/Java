package mx.sam.firstReactive.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import mx.sam.firstReactive.model.Persona;
import reactor.core.publisher.Flux;

public class Matematicos {
	
	public void average() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.collect(Collectors.averagingInt(p->p.getEdad()))
		.subscribe(p->{
			System.out.println("Reactor averagingInt:" + p);
		});
	}
	public void count() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.collect(Collectors.counting())
		.subscribe(p->{
			System.out.println("Reactor counting:" + p);
		});
	}
	public void min() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.collect(Collectors.minBy(Comparator.comparing(p->p.getEdad())))
		.subscribe(p->{
			System.out.println("Reactor min:" + p.get());
		});
	}

	
	public void summing() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.collect(Collectors.summingInt(p->p.getEdad()))
		.subscribe(p->{
			System.out.println("Reactor summing:" + p);
		});
	}
	
	public void sumarizing() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.collect(Collectors.summarizingInt(p->p.getEdad()))
		.subscribe(p->{
			System.out.println("Reactor sumarizing:" + p);
		});
	}
}
