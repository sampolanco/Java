package ejemplos.lambda.scope;

public class calcularAreaConLambda {
	static double pi=3.1416;
	double radioClase=0;
	/*
	 * Se utiliza una lambda para implementar las operaciones
	 * No se puede asignar valor a una variable externa ya que 
	 * se consideran como final aunque no lo sean
	 * No se puede volver a utilizar el mismo nombre de variable
	 * */
	public static void calcularAreaCirculoEstatico() {
		double area=0;
		Aritmetica aritmetica=(x)->{
			pi=3.14;
			//radioClase=x; Error ya que no podemos utilizar variables que no sean estaticas
			//double area=0;//La variable area no puede volverse a declarar
			double area2=pi*x*x;
			return area2;
		};
		System.out.println(aritmetica.calcularAreaCirculo(1));
	}
	
	/*
	 * Se utiliza una clase anonima para implementar las operaciones
	 * */
	public void calcularAreaCirculoNoEstatico() {
		double area=0;
		double piLocal=3.1416;
		Aritmetica aritmetica=(x)->{
			pi=3.14;
			radioClase=x;
			//double area=0;//La variable area no puede volverse a declarar
			double area2=pi*radioClase*radioClase;
			return area2;
		};
		System.out.println(aritmetica.calcularAreaCirculo(1));
	}

	public static void main(String[] args) {
		calcularAreaCirculoEstatico();
		calcularAreaConLambda calc=new calcularAreaConLambda();
		calc.calcularAreaCirculoNoEstatico();
		System.out.println(calc.radioClase);
		
	}
}
