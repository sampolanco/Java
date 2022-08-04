package mx.sam.estructural.decorator.archivo.clasesdecorator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import mx.sam.estructural.decorator.archivo.service.MyDataSource;

public class DecoradorCompresion extends DataSourceDecorator {
	private int compLevel = 6;

	public DecoradorCompresion(MyDataSource source) {
		super(source);
	}

	@Override
	public void escribirDato(String dato) {
		super.escribirDato(compress(dato));
	}

	@Override
	public String leerDato() {
		return decompress(super.leerDato());
	}

	private String compress(String stringData) {
		byte[] data = stringData.getBytes();
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
			DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel));
			dos.write(data);
			dos.close();
			bout.close();
			return Base64.getEncoder().encodeToString(bout.toByteArray());
		} catch (IOException ex) {
			return null;
		}
	}

	private String decompress(String stringData) {
		byte[] data = Base64.getDecoder().decode(stringData);
		try {
			InputStream in = new ByteArrayInputStream(data);
			InflaterInputStream iin = new InflaterInputStream(in);
			ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
			int b;
			while ((b = iin.read()) != -1) {
				bout.write(b);
			}
			in.close();
			iin.close();
			bout.close();
			return new String(bout.toByteArray());
		} catch (IOException ex) {
			return null;
		}
	}
}
