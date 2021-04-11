package ejemplos.basic;

class ClaseAnidada{
	public static void main(String[] args) {
	}
}
public class MainStringBuilder {
	int sb2;
	public static void metodoEstatico() {
		System.out.println("metodoEstatico");
	}

	
	public static void main(String[] args) {
		String cadena ="Sam";
		StringBuilder sbSam=new StringBuilder("sam");
		StringBuilder sb=new StringBuilder(100);
		sb.length();
		sb.append("012345");
		sb.delete(6, 1000);//correcto

		System.out.println(cadena.equals(sbSam));
		System.out.println(sbSam.equals(cadena));
		System.out.println(sbSam.equals(new StringBuilder("sam")));

		
		StringBuilder sb2 = new StringBuilder("TOMATO");
        System.out.println(sb2.reverse()); //Line n1
        
        //System.out.println(sb2.append(null).length()); //null es ambiguo
	}
}
