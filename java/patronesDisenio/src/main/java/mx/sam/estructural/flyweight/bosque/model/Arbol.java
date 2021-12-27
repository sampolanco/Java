package mx.sam.estructural.flyweight.bosque.model;

import java.awt.Graphics;

public class Arbol {
	private int x;
	private int y;
	private TipoArbol tipoArbol;
	
	public Arbol(int x,int y,TipoArbol tipoArbol) {
		this.x=x;
		this.y=y;
		this.tipoArbol=tipoArbol;
	}
	
    public void draw(Graphics g) {
    	tipoArbol.draw(g, x, y);
    }
}
