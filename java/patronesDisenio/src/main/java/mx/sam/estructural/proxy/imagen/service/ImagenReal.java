package mx.sam.estructural.proxy.imagen.service;

public class ImagenReal implements Imagen {

	private String nombreArchivo;

	public ImagenReal(String nombreArchivo){
	      this.nombreArchivo = nombreArchivo;
	      cargarDesdeDisco(nombreArchivo);
	   }

	@Override
	public void display() {
		System.out.println("Displaying " + nombreArchivo);
	}

	private void cargarDesdeDisco(String nombreArchivo) {
		System.out.println("Cargando " + nombreArchivo);
	}

}
