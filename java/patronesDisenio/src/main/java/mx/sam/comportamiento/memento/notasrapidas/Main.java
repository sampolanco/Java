package mx.sam.comportamiento.memento.notasrapidas;

import mx.sam.comportamiento.memento.notasrapidas.clasesmemento.Cuidador;
import mx.sam.comportamiento.memento.notasrapidas.model.Nota;

public class Main {

	public static void main(String[] args) {
		Nota nota = new Nota();
		Cuidador cuidador = new Cuidador();

		nota.setTexto("Estado #1");
		nota.setTexto("Estado #2");
		cuidador.add(nota.guardarEstadoMemento());

		nota.setTexto("Estado #3");
		cuidador.add(nota.guardarEstadoMemento());

		nota.setTexto("Estado #4");
		System.out.println("Estado actual: " + nota.getTexto());

		nota.getEstadoPorMemento(cuidador.get(0));
		System.out.println("Primer estado guardado: " + nota.getTexto());
		nota.getEstadoPorMemento(cuidador.get(1));
		System.out.println("Segundo estado guardado: " + nota.getTexto());
	}

}
