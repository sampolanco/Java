package mx.sam.creacional.singleton;

import mx.sam.creacional.singleton.model.ConexionBD;

public class Main {

	public static void main(String[] args) {
		ejecutar("Select * from clase");
		ejecutar("Select * from clase2");
		ejecutar("Select * from clase3");
		ejecutar("Select * from clase4");

	}
	
	public static void ejecutar(String query) {
		ConexionBD conexion=ConexionBD.getConexionBD();
		conexion.conectarBase();
		conexion.ejecutarQuery(query);
		conexion.desconectarBase();
	}

}
