package mx.sam.creacional.builder.desayuno.model;

import java.util.ArrayList;
import java.util.List;

public class PaqueteComida {
	private List<ElementoMenu> elementosMenu = new ArrayList<ElementoMenu>();
	
	public void agregarElementoMenu(ElementoMenu elementoMenu) {
		this.elementosMenu.add(elementoMenu);
	}
	
	public void pintarCosto() {
		float costo=0;
		for(ElementoMenu elementoMenu:elementosMenu) {
			costo+=elementoMenu.getPrecio();
		}
		System.out.println("Costo: "+costo);
	}
	public void mostrarItems() {
		System.out.println("Elementos del paquete");
		for(ElementoMenu elementoMenu:elementosMenu) {
			System.out.println("..."+ elementoMenu.getNombre());
		}
	}
}
