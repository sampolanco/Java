package mx.sam.comportamiento.observer.archivo.service;

import java.util.ArrayList;
import java.util.List;

import mx.sam.comportamiento.observer.archivo.clasesobserver.ObserverArchivo;

public class ArchivoService {
	   private List<ObserverArchivo> observers = new ArrayList<ObserverArchivo>();
	   private String texto;

	   public String getTexto() {
	      return texto;
	   }

	   public void setTexto(String texto) {
	      this.texto = texto;
	      notifyAllObservers();
	   }

	   public void attach(ObserverArchivo observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (ObserverArchivo observer : observers) {
	         observer.update();
	      }
	   } 	
}
