package mx.sam.estructural.proxy.imagen.clasesproxy;

import mx.sam.estructural.proxy.imagen.service.Imagen;
import mx.sam.estructural.proxy.imagen.service.ImagenReal;

public class ImagenProxy implements Imagen{

	   private ImagenReal imagenReal;
	   private String nombreArchivo;

	   public ImagenProxy(String nombreArchivo){
	      this.nombreArchivo = nombreArchivo;
	   }

	   @Override
	   public void display() {
	      if(imagenReal == null){
	    	  imagenReal = new ImagenReal(nombreArchivo);
	      }
	      imagenReal.display();
	   }
}
