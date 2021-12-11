package mx.sam.creacional.factory.abstractFactory.pizzeria.model;

import java.util.Arrays;

public class PizzaCuadradaEspecialidadQuesos extends Pizza {

	public PizzaCuadradaEspecialidadQuesos() {
		this.setNombrePizza("Pizza cuadrada de quesos");
		this.setFormaPizza("cuadrada");
		this.setOrilla("normal");
		this.setToppings(Arrays.asList(new String[] {"queso chedar","queso mozzarella","queso manchego"}));
	}
	
	public void cortar() {
		System.out.println("Cortando en rebanadas cuadradas");
	}
}
