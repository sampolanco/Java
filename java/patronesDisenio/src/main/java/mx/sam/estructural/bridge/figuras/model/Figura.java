package mx.sam.estructural.bridge.figuras.model;

import mx.sam.estructural.bridge.figuras.clasesbridge.IDibujar;

public abstract class Figura{
	protected IDibujar dibujar;
	
	public Figura(IDibujar dibujar){
		this.dibujar=dibujar;
	}
	public abstract void dibujar();



	
}
