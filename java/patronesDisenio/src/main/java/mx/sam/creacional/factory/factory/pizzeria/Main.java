package mx.sam.creacional.factory.factory.pizzeria;

import mx.sam.creacional.factory.factory.pizzeria.clasesfactory.PizzaFactory;
import mx.sam.creacional.factory.factory.pizzeria.model.Pizza;

public class Main {

	public static void main(String[] args) {
		ordenarPizza("ESPECIALIDAD_MEXICANA");
		ordenarPizza("ESPECIALIDAD_QUESOS");
		ordenarPizza("CUADRADA_JAMON");

	}
	private static void ordenarPizza(String tipoPizza) {
		PizzaFactory pizzaFactory= new PizzaFactory();
		Pizza pizza=pizzaFactory.crearPizza(tipoPizza);
		pizza.prepararPizza();
		pizza.cocinar();
		pizza.cortar();
		pizza.ponerEncaja();
	}
}
