package mx.sam.firstReactive.examples;

import java.util.ArrayList;
import java.util.List;

import mx.sam.firstReactive.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Transformacion {
	public void map() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.map(p->{
			p.setEdad(p.getEdad()+10);
			return p;
		})
		.subscribe(p->{
			System.out.println("Reactor map:" + p);
		});
		
		Flux<Integer> flux=Flux.range(0, 3);
		Flux<Integer> fluxmapped=flux.map(p->{
			return p+100;
		});
		fluxmapped.subscribe(p->{
			System.out.println("Reactor fluxmapped :" + p);
		});
	}
	public void flatMap() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.flatMap(p->{
			p.setEdad(p.getEdad()+10);
			return Mono.just(p);
		})
		.subscribe(p->{
			System.out.println("Reactor flatmap:" + p);
		});
	}
	
	public void groupby() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(1,"nao",23));
		personas.add(new Persona(2,"ama",20));
		personas.add(new Persona(3,"ale",30));
		

		Flux.fromIterable(personas)
		.groupBy(p->p.getId())
		.flatMap(p->{
			return p.collectList();
		})
		.subscribe(p->{
			System.out.println("Reactor groupby:" + p);
		});
	}
}
