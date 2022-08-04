package mx.sam.comportamiento.observer.archivo.clasesobserver;

import mx.sam.comportamiento.observer.archivo.service.ArchivoService;

public abstract class ObserverArchivo {

	   protected ArchivoService archivoService;
	   public abstract void update();
}
