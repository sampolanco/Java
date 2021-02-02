package ejemplos.lambda.scope;

public class calcularAreaSinLambda {
	static double pi=3.1416;
	double radioClase=0;
	/*
	 * Se utiliza una clase anonima para implementar las operaciones
	 * No se puede asignar valor a una variable externa ya que 
	 * se consideran como final aunque no lo sean
	 * */
	public static void calcularAreaCirculoEstatico() {
		double area=0;
		Aritmetica aritmetica = new Aritmetica() {
			@Override
			public double calcularAreaCirculo(double radio) {
				pi=3.14;
				//radioClase=radio; Error ya que no podemos utilizar variables que no sean estaticas
				double area=pi*radio*radio;
				return area;
			}
		};
		System.out.println(aritmetica.calcularAreaCirculo(1));
	}
	
	/*
	 * Se utiliza una clase anonima para implementar las operaciones
	 * */
	public void calcularAreaCirculoNoEstatico() {
		double area=0;
		double piLocal=3.1416;
		Aritmetica aritmetica = new Aritmetica() {
			@Override
			public double calcularAreaCirculo(double radio) {
				pi=3.14;
				radioClase=radio;
				double area=pi*radioClase*radioClase;
				return area;
			}
		};
		System.out.println(aritmetica.calcularAreaCirculo(1));
	}
	public static void main(String[] args) {
		calcularAreaCirculoEstatico();
		calcularAreaSinLambda calc=new calcularAreaSinLambda();
		calc.calcularAreaCirculoNoEstatico();
		System.out.println(calc.radioClase);	}
}
