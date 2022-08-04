package mx.sam.comportamiento.template.juego.clasestemplate;

public class FootBallJuego extends Juego {
	@Override
	public void inicializar() {
		System.out.println("FootBallJuego Inicializado!.");
	}

	@Override
	public void comenzarJuego() {
		System.out.println("FootBallJuego comienza el juego");
	}

	@Override
	public void finalizarJuego() {
		System.out.println("FootBallJuego finalizado");
	}

}
