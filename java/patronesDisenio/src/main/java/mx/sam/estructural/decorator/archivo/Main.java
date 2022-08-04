package mx.sam.estructural.decorator.archivo;

import mx.sam.estructural.decorator.archivo.clasesdecorator.*;
import mx.sam.estructural.decorator.archivo.service.ArchivoDataSource;
import mx.sam.estructural.decorator.archivo.service.MyDataSource;

public class Main {

	public static void main(String[] args) {
		String datos = "Lista de mandado:\ntortillas:20\njamon:60\nrollo:100";
		DataSourceDecorator encoded = new DecoradorCompresion(new DecoradorEncriptacion(
				new ArchivoDataSource("C:\\Users\\samy_\\Documents\\archivos\\OutputDemo.txt")));
		encoded.escribirDato(datos);
		MyDataSource plain = new ArchivoDataSource("C:\\Users\\samy_\\Documents\\archivos\\OutputDemo.txt");

		System.out.println("- Input ----------------");
		System.out.println(datos);
		System.out.println("- Encoded --------------");
		System.out.println(plain.leerDato());
		System.out.println("- Decoded --------------");
		System.out.println(encoded.leerDato());
	}

}
