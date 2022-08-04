package mx.sam.creacional.factory.factory.pizzeria.model;

import java.util.Arrays;

public class PizzaEspecialidadQuesos extends Pizza {

	public PizzaEspecialidadQuesos() {
		this.setNombrePizza("Pizza de quesos");
		this.setFormaPizza("redonda");
		this.setOrilla("normal");
		this.setToppings(Arrays.asList(new String[] {"queso chedar","queso mozzarella","queso manchego"}));
	}
}
