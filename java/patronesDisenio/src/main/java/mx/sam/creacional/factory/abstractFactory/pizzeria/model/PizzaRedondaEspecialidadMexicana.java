package mx.sam.creacional.factory.abstractFactory.pizzeria.model;

import java.util.Arrays;

public class PizzaRedondaEspecialidadMexicana extends Pizza {
	public PizzaRedondaEspecialidadMexicana() {
		this.setNombrePizza("Pizza redonda Mexicana");
		this.setFormaPizza("redonda");
		this.setOrilla("normal");
		this.setToppings(Arrays.asList(new String[] {"chorizo","frijoles","tocino"}));
	}
}
