package mx.sam.firstReactive.examples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import mx.sam.firstReactive.model.Persona;
import reactor.core.publisher.Flux;

public class Condicion {
	public void takeUntil() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.takeUntil(p->{
			return p.getId()>2;
		})
		.subscribe(p->{
			System.out.println("Reactor takeUntil:" + p);
		});
	}
	
	public void timeout() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		

		Flux.fromIterable(personas)
		.delayElements(Duration.ofSeconds(1))
		.timeout(Duration.ofSeconds(2))
		.subscribe(p->{
			System.out.println("Reactor timeout:" + p);
		});
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
