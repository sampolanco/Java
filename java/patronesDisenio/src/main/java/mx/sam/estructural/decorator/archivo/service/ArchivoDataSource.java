package mx.sam.estructural.decorator.archivo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class ArchivoDataSource implements MyDataSource{
	private String nombreArchivo;
	
	public ArchivoDataSource(String nombreArchivo) {
		this.nombreArchivo=nombreArchivo;
	}
	@Override
	public void escribirDato(String dato) {
		File file = new File(nombreArchivo);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(dato.getBytes(), 0, dato.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
	}

	@Override
	public String leerDato() {
        char[] buffer = null;
        File file = new File(nombreArchivo);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
	}

}
