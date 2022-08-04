package mx.sam.creacional.builder.desayuno;

import mx.sam.creacional.builder.desayuno.clasesbuilder.DesayunoBuilder;
import mx.sam.creacional.builder.desayuno.model.PaqueteComida;

public class Main {

	public static void main(String[] args) {
		DesayunoBuilder desayuno=new DesayunoBuilder();
		PaqueteComida paquete=desayuno.prepararPaqueteHamburguesaConPapasAguaJamaicaArrozConLeche();
		paquete.pintarCosto();
		paquete.mostrarItems();
		
		paquete=desayuno.prepararPaquetePechugaConPapasCocaColaArrozConLeche();
		paquete.pintarCosto();
		paquete.mostrarItems();
	}

}
