package mx.sam.estructural.flyweight.bosque.model;

import java.awt.Color;
import java.awt.Graphics;

public class TipoArbol {
	private String nombre;
	private Color color;
	private String datoArbol;

	public TipoArbol(String nombre, Color color, String datoArbol) {
        this.nombre = nombre;
        this.color = color;
        this.datoArbol = datoArbol;
    }

	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(x - 1, y, 3, 5);
		g.setColor(color);
		g.fillOval(x - 5, y - 10, 10, 10);
	}
}
