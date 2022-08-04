package mx.sam.comportamiento.chainofresponsibility.loggs.service;

public class ConsoleLogger extends AbstractLogger {

	   public ConsoleLogger(int nivel){
	      this.nivel = nivel;
	   }

	   @Override
	   protected void write(String mensaje) {		
	      System.out.println("Standard Console::Logger: " + mensaje);
	   }
}
