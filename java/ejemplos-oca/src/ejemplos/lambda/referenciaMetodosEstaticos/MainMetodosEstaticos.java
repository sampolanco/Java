package ejemplos.lambda.referenciaMetodosEstaticos;

import model.escuela.Aritmetica;

public class MainMetodosEstaticos {
	static double pi=3.1416;
	double radioClase=0;

	public static double calcularAreaCirculoFuncionalidadEstatico(double radio) {
		pi=3.14;
		double radioClase=1;
		//double area=0;//La variable area no puede volverse a declarar
		double area=pi*radioClase*radioClase;
		return area;
	}
	/*
	 * Se utiliza un metodo estatico para pasar como implementacion de la lambda
	 * */
	public void calcularAreaCirculo() {
		Aritmetica aritmetica2=MainMetodosEstaticos::calcularAreaCirculoFuncionalidadEstatico;
		System.out.println(aritmetica2.calcularAreaCirculo(10));
	}
	/*
	 * Referencia a constructores
	 * */
	public void crearPersona() {
		//IPersona personaImpl=(nom,apell)->{return new Persona(nom,apell);};
		IPersona personaImpl=Persona::new;
		Persona per=personaImpl.crearPersona("samuel", "polanco");
		System.out.println(per.getNombre());
	}

	public static void main(String[] args) {
		MainMetodosEstaticos clase=new MainMetodosEstaticos();
		clase.calcularAreaCirculo();		
		//Persona
		clase.crearPersona();
	}
}
