package mx.sam.comportamiento.chainofresponsibility.loggs.service;

public class FileLogger extends AbstractLogger {

	public FileLogger(int nivel) {
		this.nivel = nivel;
	}

	@Override
	protected void write(String mensaje) {
		System.out.println("File::Logger: " + mensaje);
	}
}
