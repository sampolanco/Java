package mx.sam.firstReactive;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mx.sam.firstReactive.examples.*;

@SpringBootApplication
public class FirstReactiveApplication  implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(FirstReactiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//fluxMono();
		//creacion();
		//transformacion();
		//filtrado();
		//merge();
		//errores();
		//condicion();
		matematicos();
	}

	private void fluxMono() {
		FluxMono fm=new FluxMono();
		fm.runSimpleJavaRxReactor();
		fm.runFlux();	
	}

	private void creacion() {
		Creacion c=new Creacion();
		c.range();
		c.repeat();
	}
	
	private void transformacion() {
		Transformacion t=new Transformacion();
		t.map();
		t.flatMap();
		t.groupby();
	}
	private void filtrado() {
		Filtrado f=new Filtrado();
		f.filter();
		f.distinct();
		f.take();
		f.takeLast();
		f.skip();
		f.skipLast();
	}
	private void merge() {
		Merge m=new Merge();
		m.merge();
	}
	private void errores() {
		Errores e=new Errores();
		e.retry();
		e.errorReturn();
		e.errorResume();
		e.errorMap();
	}
	private void condicion() {
		Condicion c=new Condicion();
		c.takeUntil();
		c.timeout();
	}
	private void matematicos() {
		Matematicos m=new Matematicos();
		m.average();
		m.count();
		m.min();
		m.summing();
		m.sumarizing();
	}
}
