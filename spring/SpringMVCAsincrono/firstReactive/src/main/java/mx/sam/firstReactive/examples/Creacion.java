package mx.sam.firstReactive.examples;

import mx.sam.firstReactive.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Creacion {
	public void range() {
		Flux.range(0, 3).subscribe(p -> {
			System.out.println("range :" + p);
		});
	}
	public void repeat() {
		Mono.just(new Persona(2,"ale",30))
		.repeat(3)
		.doOnNext(p->{
			p.setNombre(p.getNombre()+"R");
		})
		.subscribe(p -> {
			System.out.println("Reactor :" + p);
		});
	}
}
