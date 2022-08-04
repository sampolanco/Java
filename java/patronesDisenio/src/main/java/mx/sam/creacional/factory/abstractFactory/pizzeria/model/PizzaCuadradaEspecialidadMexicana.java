package mx.sam.creacional.factory.abstractFactory.pizzeria.model;

import java.util.Arrays;

public class PizzaCuadradaEspecialidadMexicana extends Pizza {
	public PizzaCuadradaEspecialidadMexicana() {
		this.setNombrePizza("Pizza cuadrada Mexicana");
		this.setFormaPizza("cuadrada");
		this.setOrilla("normal");
		this.setToppings(Arrays.asList(new String[] {"chorizo","frijoles","tocino"}));
	}
	
	public void cortar() {
		System.out.println("Cortando en rebanadas cuadradas");
	}
}
