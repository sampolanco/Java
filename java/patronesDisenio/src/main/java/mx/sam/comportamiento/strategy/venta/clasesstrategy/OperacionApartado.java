package mx.sam.comportamiento.strategy.venta.clasesstrategy;

public class OperacionApartado implements Strategy {
	@Override
	public int ejecutarOperacion(int parametro1, int parametro2) {
		System.out.println("Ejecutando operacion de apartado co parametros "+parametro1 + " , "+ parametro2);
		return 1;
	}
}
