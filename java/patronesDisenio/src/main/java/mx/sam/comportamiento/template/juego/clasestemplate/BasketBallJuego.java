package mx.sam.comportamiento.template.juego.clasestemplate;

public class BasketBallJuego extends Juego {
	@Override
	protected void inicializar() {
		System.out.println("BasketBallJuego Inicializado!.");
	}

	@Override
	protected void comenzarJuego() {
		System.out.println("BasketBallJuego comienza el juego");
	}

	@Override
	protected void finalizarJuego() {
		System.out.println("BasketBallJuego finalizado");
	}

}
