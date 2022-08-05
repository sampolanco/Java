package mx.sam.firstReactive.examples;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import mx.sam.firstReactive.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxMono {
	public void runSimpleJavaRxReactor() {
		reactor();
		javarx();
	}
	public void runFlux() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"sam",28));
		personas.add(new Persona(2,"nao",23));
		personas.add(new Persona(3,"ama",20));
		personas.add(new Persona(4,"ale",30));
		
		Flux.just(new Persona(1,"sam",28)).subscribe(p->{
			System.out.println("Reactor :" + p);
		});
		Flux.just(personas).subscribe(lista->{
			System.out.println("Reactor lista :" + lista);
		});

		Flux.fromIterable(personas).subscribe(p->{
			p.setEdad(p.getEdad()+10);
			System.out.println("Reactor :" + p);
		});
		
		Flux<Persona> flux=Flux.fromIterable(personas);
		flux.collectList().subscribe(lista->{
			System.out.println("Reactor flux :" + lista);
		});
		
	}
	
	private void reactor() {
		Mono.just(new Persona(1,"sam",28))
		.doOnNext(p->{
			p.setNombre("sam modificado");
		})
		.subscribe(p -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Reactor :" + p);
		});
		Mono.just(new Persona(2,"ale",30)).subscribe(p -> {
			System.out.println("Reactor :" + p);
		});
	}
	
	private void javarx() {
		Observable.just(new Persona(1,"sam",28)).subscribe(p -> {
			System.out.println("RX :" + p);
		});
		Observable.just(new Persona(2,"ale",30)).subscribe(p -> {
			System.out.println("RX :" + p);
		});
		
	}
}
