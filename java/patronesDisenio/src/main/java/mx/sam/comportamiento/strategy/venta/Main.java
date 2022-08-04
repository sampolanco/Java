package mx.sam.comportamiento.strategy.venta;

import mx.sam.comportamiento.strategy.venta.clasesstrategy.*;
import mx.sam.comportamiento.strategy.venta.service.VentaService;

public class Main {

	public static void main(String[] args) {
		VentaService ventaService = new VentaService(new OperacionVenta());
		ventaService.executeStrategy(10, 5);

		ventaService = new VentaService(new OperacionApartado());
		ventaService.executeStrategy(5, 51);

	}

}
