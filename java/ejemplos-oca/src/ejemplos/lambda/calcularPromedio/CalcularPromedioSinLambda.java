package ejemplos.lambda.calcularPromedio;

public class CalcularPromedioSinLambda {
	/*
	 * Se utiliza una clase anonima para implementar las operaciones
	 * */
	public static void calcularPromedio() {
		Aritmetica aritmetica = new Aritmetica() {
			@Override
			public double calcularPromedio(double x, double y) {
				return (x+y)/2;
			}
		};
		System.out.println(aritmetica.calcularPromedio(2, 3));
	}
	public static void main(String[] args) {
		calcularPromedio();
	}
}
