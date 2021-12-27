package mx.sam.estructural.flyweight.bosque;

import java.awt.Color;

import mx.sam.estructural.flyweight.bosque.model.*;

public class Main {

	static int CANVAS_SIZE = 500;
	static int TREES_TO_DRAW = 100000;
	static int TREE_TYPES = 2;

	public static void main(String[] args) {
		Bosque bosque = new Bosque();
		for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
			bosque.plantarArbol(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), "Limon", Color.GREEN,
					"Oak texture stub");
			bosque.plantarArbol(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), "Cedro", Color.ORANGE,
					"Autumn Oak texture stub");
		}
		bosque.setSize(CANVAS_SIZE, CANVAS_SIZE);
		bosque.setVisible(true);

		System.out.println(TREES_TO_DRAW + " arboles pintados");
		System.out.println("---------------------");
		System.out.println("Uso de memoria:");
		System.out.println("Peso arbol (8 bytes) * " + TREES_TO_DRAW);
		System.out.println("+ peso TipoArbol (~30 bytes) * " + TREE_TYPES + "");
		System.out.println("---------------------");
		System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) + "MB (instead of "
				+ ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
	}

	private static int random(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

}
