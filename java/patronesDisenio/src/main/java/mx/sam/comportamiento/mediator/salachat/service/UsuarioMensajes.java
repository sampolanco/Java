package mx.sam.comportamiento.mediator.salachat.service;

import mx.sam.comportamiento.mediator.salachat.clasesmediator.ChatRoomMediador;

public class UsuarioMensajes {
	   private String nombre;

	   public String getNombre() {
	      return nombre;
	   }

	   public void setNombre(String nombre) {
	      this.nombre = nombre;
	   }

	   public UsuarioMensajes(String nombre){
	      this.nombre  = nombre;
	   }

	   public void mandarMensaje(String mensaje){
	      ChatRoomMediador.mostrarMensaje(this,mensaje);
	   }
}
