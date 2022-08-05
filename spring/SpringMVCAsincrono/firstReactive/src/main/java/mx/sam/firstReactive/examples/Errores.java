package mx.sam.firstReactive.examples;

import java.util.ArrayList;
import java.util.List;

import mx.sam.firstReactive.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Errores {
	public void retry() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.doOnNext(p->{
			if(p.getId().equals(3)) {
				throw new RuntimeException("error");
			}
		})
		.retry(2)
		.subscribe(p->{
			System.out.println("Reactor retry:" + p);
		});
	}
	public void errorReturn() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.doOnNext(p->{
			if(p.getId().equals(3)) {
				throw new RuntimeException("error");
			}
		})
		.onErrorReturn(new Persona(0,"",0))
		.subscribe(p->{
			System.out.println("Reactor errorReturn:" + p);
		});
	}
	
	public void errorResume() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.doOnNext(p->{
			if(p.getId().equals(3)) {
				throw new RuntimeException("error");
			}
		})
		.onErrorResume(e->{
			System.out.println("Reactor onErrorResume:" + e.getMessage());
			return Mono.just(new Persona(0,"",0));
		})
		.subscribe(p->{
			System.out.println("Reactor onErrorResume:" + p);
		});
	}
	
	public void errorMap() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.doOnNext(p->{
			if(p.getId().equals(3)) {
				throw new RuntimeException("error");
			}
		})
		.onErrorMap(e->{
			System.out.println("Reactor onErrorMap:" + e.getMessage());
			return new IllegalArgumentException("argumento no valido");
		})
		.subscribe(p->{
			System.out.println("Reactor onErrorMap:" + p);
		});
	}
}
