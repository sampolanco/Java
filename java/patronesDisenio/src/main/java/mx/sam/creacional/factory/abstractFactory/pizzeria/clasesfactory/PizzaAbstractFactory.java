package mx.sam.creacional.factory.abstractFactory.pizzeria.clasesfactory;

import mx.sam.creacional.factory.abstractFactory.pizzeria.model.Pizza;

public abstract class PizzaAbstractFactory {

	public abstract Pizza crearPizza(String tipoPizza);
}
