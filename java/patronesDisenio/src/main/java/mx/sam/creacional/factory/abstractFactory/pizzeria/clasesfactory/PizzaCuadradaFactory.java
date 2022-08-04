package mx.sam.creacional.factory.abstractFactory.pizzeria.clasesfactory;

import mx.sam.creacional.factory.abstractFactory.pizzeria.model.*;

public class PizzaCuadradaFactory extends PizzaAbstractFactory{

	public Pizza crearPizza(String tipoPizza) {
		Pizza pizza = null;
		switch (tipoPizza) {
		case "JAMON":
			pizza = new PizzaCuadradaJamon();
			break;
		case "ESPECIALIDAD_MEXICANA":
			pizza= new PizzaCuadradaEspecialidadMexicana();
			break;
		case "ESPECIALIDAD_QUESOS":
			pizza= new PizzaCuadradaEspecialidadQuesos();
			break;
		default:
			System.out.println("pizza desconocida");
		}
		return pizza;
	}
}
