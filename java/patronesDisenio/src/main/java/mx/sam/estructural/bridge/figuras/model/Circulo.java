package mx.sam.estructural.bridge.figuras.model;

import mx.sam.estructural.bridge.figuras.clasesbridge.IDibujar;

public class Circulo extends Figura{
	private int x;
	private int y;
	private int radio;
	
	public Circulo(int x,int y,int radio,IDibujar dibujar) {
		super(dibujar);
		this.x=x;
		this.y=y;
		this.radio=radio;
	}

	@Override
	public void dibujar() {
		dibujar.dibujarCirculo(radio, x, y);
	}


}
