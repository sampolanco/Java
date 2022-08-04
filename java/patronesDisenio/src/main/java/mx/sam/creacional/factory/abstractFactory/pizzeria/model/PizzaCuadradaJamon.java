package mx.sam.creacional.factory.abstractFactory.pizzeria.model;

import java.util.Arrays;

public class PizzaCuadradaJamon extends Pizza {
	public PizzaCuadradaJamon() {
		this.setNombrePizza("Pizza Cuadrada de jamon");
		this.setFormaPizza("cuadrada");
		this.setOrilla("normal");
		this.setToppings(Arrays.asList(new String[] {"jamon"}));
	}
	
	public void cortar() {
		System.out.println("Cortando en rebanadas cuadradas");
	}
}
