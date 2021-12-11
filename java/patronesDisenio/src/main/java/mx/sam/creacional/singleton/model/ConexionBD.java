package mx.sam.creacional.singleton.model;

public class ConexionBD {

	private String ip;
	private String puerto;
	
	private static ConexionBD conexionBD;

	
	private ConexionBD() {}
	
	public void conectarBase() {
		System.out.println("Clase: "+ this+" conectandose a la bd");
	}
	public void ejecutarQuery(String query) {
		System.out.println("Clase: "+ this+" ejecutando query: "+query);
	}
	
	
	public void desconectarBase() {
		System.out.println("Clase: "+ this+" desconectandose a la bd");
	}

	public static synchronized ConexionBD getConexionBD() {
		if(conexionBD==null) {
			System.out.println("Se crea clase ");
			conexionBD=new ConexionBD();
		}
		return conexionBD;
	}
	
	
	
	
}
