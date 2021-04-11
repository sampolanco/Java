package ejemplos.tiposDatos;

public class MainString {

	public static final void main(String[] args)  {
		String str1 = "hello"; 
		String str2 = "hello"; 
		String str3 = new String("hello"); 

		System.out.println( str1 == str2); // prints true
		System.out.println( str1 == str3); // prints false
		System.out.println( str1.equals( str3)); // prints true
		
		System.out.println(new String("sam").substring(1));
		
	}
	private static void prueba(String dato) {
		switch (dato){
			case "sam":
				
				break;
		}
	}

}
