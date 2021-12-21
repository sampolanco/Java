package mx.sam.estructural.bridge.figuras;

import mx.sam.estructural.bridge.figuras.clasesbridge.CirculoRojo;
import mx.sam.estructural.bridge.figuras.clasesbridge.CirculoVerde;
import mx.sam.estructural.bridge.figuras.model.Circulo;
import mx.sam.estructural.bridge.figuras.model.Figura;

public class Main {

	public static void main(String[] args) {
	      Figura circuloRojo = new Circulo(100,100, 10, new CirculoRojo());
	      Figura circuloVerde = new Circulo(100,100, 10, new CirculoVerde());

	      circuloRojo.dibujar();
	      circuloVerde.dibujar();
	}

}
