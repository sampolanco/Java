import java.util.List;
import java.util.Stack;

import util.Persona;

public class StackExamples {
	private static void simple() {
		Stack<String> stack=new Stack<String>();
		stack.push("Samuel");
		stack.push("Amadeus");
		stack.push("Naomi");
		stack.push("Aurora");
		stack.push("Servando");
		System.out.println(
				"peek "+stack.peek()+
				",pop "+ stack.pop()+
				",peek "+ stack.peek());
		System.out.println("------");
		System.out.println("Elemento con indice 0 "+stack.get(0));
		System.out.println("------");
		for(String elemento:stack)
			System.out.println("Elemento "+elemento);

	}
	/*
	 * Metodo para obtener el elemento maximo en la pila
	 * Se crea un nuevo stack y por cada push en el stack original
	 * Se agrega el elemento maximo en el stack antiguo
	 * cuando se elimina un elemento del original, tambien se elimina del antiguo
	 * */
	private static void maximumStack() {
		Stack<Integer> stack=new Stack<Integer>();
		Stack<Integer> stackMaximos=new Stack<Integer>();

		stack.push(1);
		stackMaximos.push(1);
		stack.push(0);
		stackMaximos.push(1);
		stack.push(2);
		stackMaximos.push(2);
		stack.push(3);
		stackMaximos.push(3);
		stack.push(1);
		stackMaximos.push(3);
		
		System.out.println("Maximo "+ stackMaximos.peek());
		System.out.println("pop "+ stack.pop());
		//El maximo sigue siendo 3
		stackMaximos.pop();
		System.out.println("Maximo "+ stackMaximos.peek());
		System.out.println("pop "+ stack.pop());
		//Como se eliminó el 3. El elemento maximo ahora es el 2
		stackMaximos.pop();
		System.out.println("Maximo "+ stackMaximos.peek());
	}
	
	/*
	 * Imitar comportamiento de cola a partir del stack
	 * Remueve el ultimo elemento del stack
	 * */
	private static void removeAsQueue(Stack<String> stack) {
		Stack<String> stackCopia=new Stack<String>();
		//Se sacan y meten los elementos en el nuevo Stack
		for(int i=stack.size();i>0;i--)
			stackCopia.add(stack.pop());
		//Como el nuevo stack está volteado se puede eliminar el elemento
		stackCopia.pop();
		//Se hace la operacion Inversa
		for(int i=stackCopia.size();i>0;i--)
			stack.add(stackCopia.pop());
	}
	/*
	 * Imitar comportamiento de cola a partir del stack
	 * Remueve el ultimo elemento del stack
	 * */
	private static String removeAsQueueRecursivo(Stack<String> stack) {
		if(stack.size()==1) {
			//Si solo hay mas elementos en el stack(primer elemento de la fila)
			return stack.pop();
		}
		else{
			String valor=stack.pop();
			String result=removeAsQueueRecursivo(stack);
			//Se regresan los valores
			stack.add(valor);
			return result;
		}
	}
	
	public static void main(String[] args) {
		simple();
		System.out.println("--------");
		maximumStack();
		System.out.println("--------");
		Stack<String> stack=new Stack<String>();
		stack.push("Samuel");
		stack.push("Amadeus");
		stack.push("Naomi");
		stack.push("Aurora");
		stack.push("Servando");
		removeAsQueue(stack);
		for(String elemento:stack)
			System.out.println("stack "+ elemento);
		System.out.println("--------");
		String elementoBorrado=removeAsQueueRecursivo(stack);
		System.out.println("Elemento borrado "+ elementoBorrado);
		for(String elemento:stack)
			System.out.println("stack "+ elemento);
	}
}
