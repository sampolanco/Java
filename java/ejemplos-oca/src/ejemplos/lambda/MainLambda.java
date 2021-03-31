package ejemplos.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import model.escuela.Escuela;

public class MainLambda {
	public static void main(String... args) {
		consumer();
		//scope();
	}
	public static void scope(String variableMetodo) {
		Consumer<String> consumerImprimirTamaño=(String s)->{
			String variableLambda="bb";
			System.out.println(variableMetodo.length());
		};
		consumerImprimirTamaño.accept("Holaaa");
	}
	public static void predicado() {
		Predicate<String> predicado=(String s)->{
			System.out.println(s.length());
			return true;
		};
	}
	
	public static void consumer() {
		Consumer<String> consumerImprimirTamaño=(String s)->{System.out.println(s.length());};
		consumerImprimirTamaño.accept("Holaaa");
	}
	public static void supplier() {
		Supplier<Escuela> supplierEscuela=()->{
			Escuela escuela =new Escuela();
			escuela.setNombre("nombreEscuela");
			return escuela;
		};
		Escuela escuelaMetodo=supplierEscuela.get();
	}
}
