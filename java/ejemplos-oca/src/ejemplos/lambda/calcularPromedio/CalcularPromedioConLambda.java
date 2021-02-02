package ejemplos.lambda.calcularPromedio;

public class CalcularPromedioConLambda {

	/*
	 * Se utiliza una lambra que usa una interface para implementar las operaciones
	 * */
	public static void calcularPromedio() {
		/*Aritmetica aritmetica = new Aritmetica() {
			@Override
			public double calcularPromedio(double x, double y) {
				return (x+y)/2;
			}
			@Override
			public double calcularPromedio(double x, double y, double z) {
				return (x+y+z)/3;
			}
		};*/
		Aritmetica aritmetica=(double x, double y)->(x+y)/2;
		System.out.println(aritmetica.calcularPromedio(2, 3));
	}
	/*
	 * Distintos tipos de sintaxis para una lambdas
	 * */
	public static void sintaxisLambda() {
		//Sintaxis basica
		Aritmetica aritmetica=(double x, double y)->(x+y)/2;
		//Con llaves 
		Aritmetica aritmetica2=(double x, double y)->{
			System.out.println("Otra sintaxis lambda");
			return (x+y)/2;
		};
		//Sin tipo de parametros ya que están definidos en la interface
		Aritmetica aritmetica3=(x, y)->(x+y)/2;
		//Sin parametro (Debe tener su interface definida)
		//Aritmetica aritmetica4=()->(4+3)/2;
		
	}
	public static void main(String[] args) {
		calcularPromedio();
	}
}
