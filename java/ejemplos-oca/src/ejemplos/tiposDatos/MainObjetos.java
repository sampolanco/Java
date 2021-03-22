package ejemplos.tiposDatos;

public class MainObjetos {

	public static void main(String... args) {
		short shortLocal=10;
		int intLocal=10;
		Integer intLocalClase=new Integer("10");
		Short shortLocalClase =new Short((short)intLocal);
		
		float floatLocal=intLocalClase.floatValue();
		int intLocal2=intLocalClase;
		int intLocal3=shortLocalClase;
		System.out.println(intLocalClase);
	}
}
