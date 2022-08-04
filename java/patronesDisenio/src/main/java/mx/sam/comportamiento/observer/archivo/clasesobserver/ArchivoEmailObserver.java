package mx.sam.comportamiento.observer.archivo.clasesobserver;

import mx.sam.comportamiento.observer.archivo.service.ArchivoService;

public class ArchivoEmailObserver  extends ObserverArchivo{

	   public ArchivoEmailObserver(ArchivoService archivoService){
	      this.archivoService = archivoService;
	      this.archivoService.attach(this);
	   }

	   @Override
	   public void update() {
	     System.out.println( "ArchivoEmailObserver. Se envia correo a x_x@gmail.com. El texto se modificó: "+ archivoService.getTexto()); 
	   }
}
