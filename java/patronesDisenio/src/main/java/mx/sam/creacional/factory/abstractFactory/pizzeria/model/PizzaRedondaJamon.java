package mx.sam.creacional.factory.abstractFactory.pizzeria.model;

import java.util.Arrays;

public class PizzaRedondaJamon extends Pizza {
	public PizzaRedondaJamon() {
		this.setNombrePizza("Pizza redonda de jamon");
		this.setFormaPizza("redonda");
		this.setOrilla("normal");
		this.setToppings(Arrays.asList(new String[] {"jamon"}));
	}
	
}
