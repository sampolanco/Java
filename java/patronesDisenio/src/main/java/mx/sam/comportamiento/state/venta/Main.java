package mx.sam.comportamiento.state.venta;

import mx.sam.comportamiento.state.venta.clasesstate.ValicacionCreditoState;
import mx.sam.comportamiento.state.venta.clasesstate.ValidacionContadoState;
import mx.sam.comportamiento.state.venta.clasesstate.ValidacionesVentaState;
import mx.sam.comportamiento.state.venta.service.VentaService;

public class Main {

	public static void main(String[] args) {
		VentaService ventaService = new VentaService();

		ValidacionesVentaState ventaEstado = new ValicacionCreditoState();
		ventaEstado.ejecutarValidacion(ventaService);

		System.out.println(ventaService.getState().toString());

		ValidacionesVentaState contadoEstado = new ValidacionContadoState();
		contadoEstado.ejecutarValidacion(ventaService);

		System.out.println(ventaService.getState().toString());
	}

}
