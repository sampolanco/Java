package mx.sam.comportamiento.observer.archivo.clasesobserver;

import mx.sam.comportamiento.observer.archivo.service.ArchivoService;

public class ArchivoLogObserver extends ObserverArchivo{

	   public ArchivoLogObserver(ArchivoService archivoService){
	      this.archivoService = archivoService;
	      this.archivoService.attach(this);
	   }

	   @Override
	   public void update() {
	     System.out.println( "ArchivoLogObserver. Se pinta en los logs. El texto se modificó: "+ archivoService.getTexto()); 
	   }
}
