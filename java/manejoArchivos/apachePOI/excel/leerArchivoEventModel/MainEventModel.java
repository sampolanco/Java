package javaEjemplos.archivos.eventmodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainEventModel {

	public static void main(String[] args) throws IOException {
		File initialFile = new File("C:\\Users\\samy_\\Desktop\\HACIENDA\\moccfi\\PLANTILLA_MALA.xlsx");
		InputStream stream;
		LeerArchivoEventModel leerArchivo=new LeerArchivoEventModel();
		try {
			stream = new FileInputStream(initialFile);
			boolean valido = leerArchivo.validateEncabezados(new String[] { "Fecha", "Tasa variable" }, stream);
			System.out.println("Valido: " + valido);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
