package mx.sam.comportamiento.chainofresponsibility.loggs;

import mx.sam.comportamiento.chainofresponsibility.loggs.service.*;

public class Main {

	//Se define la cadena de logs
	private static AbstractLogger getChainOfLoggers() {
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);

		return errorLogger;
	}

	public static void main(String[] args) {
		AbstractLogger loggerChain = getChainOfLoggers();

		loggerChain.logMessage(AbstractLogger.INFO, "Informacion ");

		loggerChain.logMessage(AbstractLogger.DEBUG, "Informacion para debug");

		loggerChain.logMessage(AbstractLogger.ERROR, "Informacion de error");
	}

}
