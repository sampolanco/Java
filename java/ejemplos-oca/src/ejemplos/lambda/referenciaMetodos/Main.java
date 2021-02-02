package ejemplos.lambda.referenciaMetodos;

public class Main {
	static double pi=3.1416;
	double radioClase=0;

	public static double calcularAreaCirculoFuncionalidadEstatico() {
		pi=3.14;
		double radioClase=1;
		//double area=0;//La variable area no puede volverse a declarar
		double area=pi*radioClase*radioClase;
		return area;
	}
	public double calcularAreaCirculoFuncionalidad() {
		pi=3.14;
		double radioClase=1;
		//double area=0;//La variable area no puede volverse a declarar
		double area=pi*radioClase*radioClase;
		return area;
	}
	/*
	 * Se utiliza un metodo estatico para pasar como implementacion de la lambda
	 * Para este tipo de anotacion no se permiten parametros
	 * Commo no recibe parametro se puede usar la exprecion 2
	 * */
	public void calcularAreaCirculo() {
		Aritmetica aritmetica=()->Main.calcularAreaCirculoFuncionalidadEstatico();
		Aritmetica aritmetica2=Main::calcularAreaCirculoFuncionalidadEstatico;

		System.out.println(aritmetica.calcularAreaCirculo());
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
		Main clase=new Main();
		clase.calcularAreaCirculo();
		Aritmetica aritmetica3=clase::calcularAreaCirculoFuncionalidad;
		System.out.println(aritmetica3.calcularAreaCirculo());
		
		//Persona
		clase.crearPersona();
	}
}
