package mx.sam.comportamiento.chainofresponsibility.loggs.service;

public abstract class AbstractLogger {
	   public static int INFO = 1;
	   public static int DEBUG = 2;
	   public static int ERROR = 3;

	   protected int nivel;

	   //next element in chain or responsibility
	   protected AbstractLogger nextLogger;

	   public void setNextLogger(AbstractLogger nextLogger){
	      this.nextLogger = nextLogger;
	   }

	   public void logMessage(int nivel, String mensaje){
	      if(this.nivel <= nivel){
	         write(mensaje);
	      }
	      if(nextLogger !=null){
	         nextLogger.logMessage(nivel, mensaje);
	      }
	   }

	   abstract protected void write(String message);
}
