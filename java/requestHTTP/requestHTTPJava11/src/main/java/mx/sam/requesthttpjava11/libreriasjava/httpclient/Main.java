package mx.sam.requesthttpjava11.libreriasjava.httpclient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

		Peticiones peticionesJavaNet=new Peticiones();
		peticionesJavaNet.peticionGetSimple();
		peticionesJavaNet.peticionGetSimpleAsincrona();

	}

}
