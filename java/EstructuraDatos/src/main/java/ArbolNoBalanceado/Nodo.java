package ArbolNoBalanceado;

public class Nodo {
	private Integer dato;
	private Nodo izquierdo;
	private Nodo derecho;
	
	public Nodo(Integer dato) {
		this.dato=dato;
		this.izquierdo=null;
		this.derecho=null;
	}
	public Integer getDato() {
		return dato;
	}
	public void setDato(Integer dato) {
		this.dato = dato;
	}
	public Nodo getIzquierdo() {
		return izquierdo;
	}
	public void setIzquierdo(Nodo izquierdo) {
		this.izquierdo = izquierdo;
	}
	public Nodo getDerecho() {
		return derecho;
	}
	public void setDerecho(Nodo derecho) {
		this.derecho = derecho;
	}

	
}
