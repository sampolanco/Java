package mx.sam.comportamiento.memento.notasrapidas.model;

import mx.sam.comportamiento.memento.notasrapidas.clasesmemento.Memento;

public class Nota {
	private String texto;



	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Memento guardarEstadoMemento() {
		return new Memento(texto);
	}

	public void getEstadoPorMemento(Memento memento) {
		texto = memento.getEstado();
	}
}
