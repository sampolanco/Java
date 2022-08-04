package mx.sam.creacional.factory.abstractFactory.pizzeria.clasesfactory;

import mx.sam.creacional.factory.abstractFactory.pizzeria.model.*;

public class PizzaRedondaFactory extends PizzaAbstractFactory{

	public Pizza crearPizza(String tipoPizza) {
		Pizza pizza = null;
		switch (tipoPizza) {
		case "JAMON":
			pizza = new PizzaRedondaJamon();
			break;
		case "ESPECIALIDAD_MEXICANA":
			pizza= new PizzaRedondaEspecialidadMexicana();
			break;
		case "ESPECIALIDAD_QUESOS":
			pizza= new PizzaRedondaEspecialidadQuesos();
			break;
		default:
			System.out.println("pizza desconocida");
		}
		return pizza;
	}
}
