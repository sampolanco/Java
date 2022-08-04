package mx.sam.creacional.factory.abstractFactory.pizzeria;

import mx.sam.creacional.factory.abstractFactory.pizzeria.clasesfactory.PizzaAbstractFactory;
import mx.sam.creacional.factory.abstractFactory.pizzeria.clasesfactory.PizzaCuadradaFactory;
import mx.sam.creacional.factory.abstractFactory.pizzeria.clasesfactory.PizzaRedondaFactory;
import mx.sam.creacional.factory.abstractFactory.pizzeria.model.Pizza;

public class Main {

	public static void main(String[] args) {
		PizzaAbstractFactory factoryRedonda=getPizzaFactory(true);
		PizzaAbstractFactory factoryCuadrada=getPizzaFactory(false);

		ordenarPizza(factoryRedonda, "ESPECIALIDAD_MEXICANA");
		ordenarPizza(factoryCuadrada,"ESPECIALIDAD_QUESOS");
		ordenarPizza(factoryCuadrada,"JAMON");

	}
	private static PizzaAbstractFactory getPizzaFactory(boolean isRedonda) {
		if(isRedonda)
			return new PizzaRedondaFactory();
		else
			return new PizzaCuadradaFactory();
	}
	private static void ordenarPizza(PizzaAbstractFactory pizzaFactory,String tipoPizza) {
		Pizza pizza=pizzaFactory.crearPizza(tipoPizza);
		pizza.prepararPizza();
		pizza.cocinar();
		pizza.cortar();
		pizza.ponerEncaja();
	}
}
