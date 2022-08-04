package mx.sam.creacional.factory.factory.pizzeria.model;

import java.util.Arrays;

public class PizzaEspecialidadMexicana extends Pizza {
	public PizzaEspecialidadMexicana() {
		this.setNombrePizza("Pizza Mexicana");
		this.setFormaPizza("redonda");
		this.setOrilla("normal");
		this.setToppings(Arrays.asList(new String[] {"chorizo","frijoles","tocino"}));
	}
}
