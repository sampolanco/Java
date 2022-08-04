package mx.sam.comportamiento.mediator.salachat;

import mx.sam.comportamiento.mediator.salachat.service.UsuarioMensajes;

public class Main {

	public static void main(String[] args) {
		UsuarioMensajes robert = new UsuarioMensajes("Robert");
		UsuarioMensajes john = new UsuarioMensajes("John");

		robert.mandarMensaje("Hola! John!");
		john.mandarMensaje("Hola! Robert!");
	}

}
