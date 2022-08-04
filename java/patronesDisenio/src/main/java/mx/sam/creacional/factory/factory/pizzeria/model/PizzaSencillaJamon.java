package mx.sam.creacional.factory.factory.pizzeria.model;

import java.util.Arrays;

public class PizzaSencillaJamon extends Pizza {
	public PizzaSencillaJamon() {
		this.setNombrePizza("Pizza sencilla de jamon");
		this.setFormaPizza("redonda");
		this.setOrilla("normal");
		this.setToppings(Arrays.asList(new String[] {"jamon"}));
	}
}
