package mx.sam.comportamiento.state.venta.service;

import mx.sam.comportamiento.state.venta.clasesstate.ValidacionesVentaState;

public class VentaService {
	private ValidacionesVentaState validacionesVentaState;

	public VentaService() {
		validacionesVentaState = null;
	}

	public void setState(ValidacionesVentaState validacionesVentaState) {
		this.validacionesVentaState = validacionesVentaState;
	}

	public ValidacionesVentaState getState() {
		return validacionesVentaState;
	}

}
