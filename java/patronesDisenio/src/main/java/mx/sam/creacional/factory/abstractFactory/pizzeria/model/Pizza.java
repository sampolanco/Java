package mx.sam.creacional.factory.abstractFactory.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
	private String nombrePizza;
	private List<String> toppings = new ArrayList<String>();
	private String orilla;
	private String formaPizza;
	
	public void prepararPizza() {
		System.out.println("----------------------------");
		System.out.println("Preparando pizza " + nombrePizza);
		System.out.println("...Agregando queso");
		System.out.println("...Agregando salsa");
		System.out.println("...Agregando toppings: ");
		for(String topping: toppings) {
			System.out.println("......"+topping);
		}
	}
	
	public void cocinar() {
		System.out.println("Cocinando por 30 minutos");
	}
	
	public void cortar() {
		System.out.println("Cortando en rebanadas triangulares");

	}
	
	public void ponerEncaja() {
		System.out.println("Poniendo en caja");
	}

	public String getNombrePizza() {
		return nombrePizza;
	}

	public void setNombrePizza(String nombrePizza) {
		this.nombrePizza = nombrePizza;
	}

	public List<String> getToppings() {
		return toppings;
	}

	public void setToppings(List<String> toppings) {
		this.toppings = toppings;
	}

	public String getOrilla() {
		return orilla;
	}

	public void setOrilla(String orilla) {
		this.orilla = orilla;
	}

	public String getFormaPizza() {
		return formaPizza;
	}

	public void setFormaPizza(String formaPizza) {
		this.formaPizza = formaPizza;
	}

	
	
}
