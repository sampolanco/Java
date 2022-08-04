package mx.sam.creacional.builder.desayuno.clasesbuilder;

import mx.sam.creacional.builder.desayuno.model.PaqueteComida;
import mx.sam.creacional.builder.desayuno.model.alimentos.*;
import mx.sam.creacional.builder.desayuno.model.bebidas.AguaSabor;

public class DesayunoBuilder {
	public PaqueteComida prepararPaqueteHamburguesaConPapasAguaJamaicaArrozConLeche() {
		PaqueteComida paquete=new PaqueteComida();
		paquete.agregarElementoMenu(new Hamburguesa());
		paquete.agregarElementoMenu(new PapasFritas());
		paquete.agregarElementoMenu(new ArrozConLeche());
		paquete.agregarElementoMenu(new AguaSabor("Jamaica"));
		return paquete;
	}
	public PaqueteComida prepararPaquetePechugaConPapasCocaColaArrozConLeche() {
		PaqueteComida paquete=new PaqueteComida();
		paquete.agregarElementoMenu(new Pechuga());
		paquete.agregarElementoMenu(new PapasFritas());
		paquete.agregarElementoMenu(new ArrozConLeche());
		paquete.agregarElementoMenu(new AguaSabor("Coca cola"));
		return paquete;
	}
}
