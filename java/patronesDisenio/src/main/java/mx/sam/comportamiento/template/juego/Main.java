package mx.sam.comportamiento.template.juego;

import mx.sam.comportamiento.template.juego.clasestemplate.BasketBallJuego;
import mx.sam.comportamiento.template.juego.clasestemplate.FootBallJuego;
import mx.sam.comportamiento.template.juego.clasestemplate.Juego;

public class Main {

	public static void main(String[] args) {
		Juego juego = new FootBallJuego();
		juego.jugar();
		System.out.println();
		juego = new BasketBallJuego();
		juego.jugar();
	}

}
