package mx.sam.comportamiento.state.venta.clasesstate;

import mx.sam.comportamiento.state.venta.service.VentaService;

public class ValidacionContadoState implements ValidacionesVentaState {

	@Override
	public void ejecutarValidacion(VentaService ventaService) {
		System.out.println("ValidacionContadoState. Se ejecuta validacion (se debe pagar el total)");
		ventaService.setState(this);
	}

	public String toString() {
		return "Estado de contado";
	}

}
