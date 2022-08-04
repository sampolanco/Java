package mx.sam.comportamiento.state.venta.clasesstate;

import mx.sam.comportamiento.state.venta.service.VentaService;

public class ValicacionCreditoState implements ValidacionesVentaState {

	@Override
	public void ejecutarValidacion(VentaService ventaService) {
		System.out.println("ValicacionCreditoState. Se ejecuta validacion (no se debe pagar el total)");
		ventaService.setState(this);
	}

	public String toString() {
		return "Estado de credito";
	}
}
