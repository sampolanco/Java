package mx.sam.estructural.decorator.archivo.clasesdecorator;

import java.util.Base64;

import mx.sam.estructural.decorator.archivo.service.MyDataSource;

public class DecoradorEncriptacion extends DataSourceDecorator {

	public DecoradorEncriptacion(MyDataSource source) {
		super(source);
	}

	@Override
	public void escribirDato(String dato) {
		super.escribirDato(encode(dato));
	}

	@Override
	public String leerDato() {
		return decode(super.leerDato());
	}

	private String encode(String data) {
		byte[] result = data.getBytes();
		for (int i = 0; i < result.length; i++) {
			result[i] += (byte) 1;
		}
		return Base64.getEncoder().encodeToString(result);
	}

	private String decode(String data) {
		byte[] result = Base64.getDecoder().decode(data);
		for (int i = 0; i < result.length; i++) {
			result[i] -= (byte) 1;
		}
		return new String(result);
	}
}
