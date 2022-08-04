package mx.sam.comportamiento.mediator.salachat.clasesmediator;

import java.util.Date;

import mx.sam.comportamiento.mediator.salachat.service.UsuarioMensajes;

public class ChatRoomMediador {
	public static void mostrarMensaje(UsuarioMensajes usuariomensaje, String mensaje) {
		System.out.println(new Date().toString() + " [" + usuariomensaje.getNombre() + "] : " + mensaje);
	}
}
