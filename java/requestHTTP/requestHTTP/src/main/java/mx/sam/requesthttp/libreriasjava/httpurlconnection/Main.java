package mx.sam.requesthttp.libreriasjava.httpurlconnection;

import java.io.IOException;
public class Main {
	
	public static void main(String[] args) throws IOException {
		Peticiones peticionesJavaNet=new Peticiones();
		peticionesJavaNet.peticionGetSimple();
		peticionesJavaNet.peticionGetConParametros();
	}

}
