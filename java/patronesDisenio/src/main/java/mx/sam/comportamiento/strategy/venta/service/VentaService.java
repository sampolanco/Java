package mx.sam.comportamiento.strategy.venta.service;

import mx.sam.comportamiento.strategy.venta.clasesstrategy.Strategy;

public class VentaService {
	   private Strategy strategy;

	   public VentaService(Strategy strategy){
	      this.strategy = strategy;
	   }

	   public int executeStrategy(int parametro1, int parametro2){
	      return strategy.ejecutarOperacion(parametro1, parametro2);
	   }

}
