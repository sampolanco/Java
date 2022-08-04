package mx.sam.comportamiento.template.juego.clasestemplate;

public abstract class Juego {
	protected abstract void inicializar();

	abstract protected void comenzarJuego();

	protected abstract void finalizarJuego();

	// template method
	public final void jugar() {

		inicializar();

		comenzarJuego();

		finalizarJuego();
	}
}
