import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueExamples {
	private static void simple() {		
		Queue<String> queue=new LinkedList<String>();
		queue.add("Samuel");
		queue.add("Amadeus");
		queue.add("Naomi");
		queue.add("Aurora");
		queue.add("Servando");
		System.out.println(
				"peek "+queue.peek()+
				",remove "+ queue.remove()+
				",peek "+ queue.peek());
		System.out.println("------");
		for(String elemento:queue)
			System.out.println("Elemento "+elemento);
		System.out.println("------");
		System.out.println(
				"peek "+queue.peek()+
				",remove "+ queue.remove()+
				",peek "+ queue.peek());
	}
	
	public static void main(String[] args) {
		simple();
	}
}
