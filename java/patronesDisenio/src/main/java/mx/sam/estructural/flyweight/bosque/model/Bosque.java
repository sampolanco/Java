package mx.sam.estructural.flyweight.bosque.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import mx.sam.estructural.flyweight.bosque.clasesflyweight.ArbolFlyweight;

public class Bosque extends JFrame {
	private static final long serialVersionUID = 1L;
	private List<Arbol> trees = new ArrayList<>();

    public void plantarArbol(int x, int y, String nombre, Color color, String datoArbol) {
        TipoArbol tipo = ArbolFlyweight.getTipoArbol(nombre, color, datoArbol);
        Arbol arbol = new Arbol(x, y, tipo);
        trees.add(arbol);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Arbol tree : trees) {
            tree.draw(graphics);
        }
    }
}
