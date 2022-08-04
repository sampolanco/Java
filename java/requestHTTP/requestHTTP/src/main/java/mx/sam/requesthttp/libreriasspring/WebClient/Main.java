package mx.sam.requesthttp.libreriasspring.WebClient;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Peticiones peticiones=new Peticiones();
		peticiones.peticionGetSimple();
		peticiones.peticionGetMapeadoJson();

	}

}
