package mx.sam.comportamiento.chainofresponsibility.loggs.service;

public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int nivel) {
		this.nivel = nivel;
	}

	@Override
	protected void write(String mensaje) {
		System.out.println("Error Console::Logger: " + mensaje);
	}
}