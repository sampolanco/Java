package mx.sam.creacional.factory.factory.pizzeria.clasesfactory;

import mx.sam.creacional.factory.factory.pizzeria.model.*;

public class PizzaFactory {

	public Pizza crearPizza(String tipoPizza) {
		Pizza pizza=null;
		switch (tipoPizza) {
			case "CUADRADA_JAMON":
				pizza= new PizzaCuadradaJamon();
				break;
			case "ESPECIALIDAD_MEXICANA":
				pizza= new PizzaEspecialidadMexicana();
				break;
			case "ESPECIALIDAD_QUESOS":
				pizza= new PizzaEspecialidadQuesos();
				break;
			case "SENCILLA_JAMON":
				pizza= new PizzaSencillaJamon();
				break;
			default:
				System.out.println("pizza desconocida");
		}
		return pizza;
	}
}
