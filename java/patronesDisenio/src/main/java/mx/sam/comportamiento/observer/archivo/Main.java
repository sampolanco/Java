package mx.sam.comportamiento.observer.archivo;

import mx.sam.comportamiento.observer.archivo.clasesobserver.ArchivoEmailObserver;
import mx.sam.comportamiento.observer.archivo.clasesobserver.ArchivoLogObserver;
import mx.sam.comportamiento.observer.archivo.service.*;

public class Main {

	public static void main(String[] args) {
		ArchivoService archivo = new ArchivoService();

	      new ArchivoEmailObserver(archivo);
	      new ArchivoLogObserver(archivo);

	      System.out.println("Primer cambio de estado a : sam");	
	      archivo.setTexto("sam");
	      System.out.println("Primer cambio de estado a : ale");	
	      archivo.setTexto("ale");
	}

}
