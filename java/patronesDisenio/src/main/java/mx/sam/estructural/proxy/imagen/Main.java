package mx.sam.estructural.proxy.imagen;

import mx.sam.estructural.proxy.imagen.clasesproxy.ImagenProxy;
import mx.sam.estructural.proxy.imagen.service.Imagen;

public class Main {

	public static void main(String[] args) {
		Imagen image = new ImagenProxy("test_10mb.jpg");

		image.display();
		System.out.println("");

		image.display();
	}

}
