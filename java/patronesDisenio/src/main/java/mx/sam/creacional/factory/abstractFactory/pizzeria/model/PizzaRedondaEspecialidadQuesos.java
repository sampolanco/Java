package mx.sam.creacional.factory.abstractFactory.pizzeria.model;

import java.util.Arrays;

public class PizzaRedondaEspecialidadQuesos extends Pizza {

	public PizzaRedondaEspecialidadQuesos() {
		this.setNombrePizza("Pizza redonda de quesos");
		this.setFormaPizza("redonda");
		this.setOrilla("normal");
		this.setToppings(Arrays.asList(new String[] {"queso chedar","queso mozzarella","queso manchego"}));
	}
}
