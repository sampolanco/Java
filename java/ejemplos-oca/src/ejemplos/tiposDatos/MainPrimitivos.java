package ejemplos.tiposDatos;

public class MainPrimitivos {
	static final int tipoInt=10;
	static byte tipoByte=32;
	static byte tipoByte2=(byte)32.50; //Mantiene solo 32
	static byte tipoByte3=tipoInt; //Imprime -128 ya que existe una perdida de informacion

	public static void main(String... args) {
		final int tipoIntLocalFinal=100;
		byte tipoByteLocal= 10;
		short tipoShortLocal=tipoByteLocal;
		char tipoCharLocal= tipoIntLocalFinal;
		int tipoIntLocal=tipoShortLocal;
		long tipoLongLocal=tipoIntLocal;
		float tipoFloatLocal=tipoLongLocal;
		double tipoDoubleLocal=tipoFloatLocal;
		
		//Casteo aunque sean del mismo tamaño
		int tipoIntDesdeFloat=(int)tipoFloatLocal;
		long tipoLongDesdeDouble=(long)tipoDoubleLocal;
		
		System.out.print("valor: "+tipoLongDesdeDouble);
		
		//casteo en metodo
		procesar((byte)tipoIntLocalFinal);
		
	}
	
	public static void procesar(byte byteMetodo) {
	}
}
