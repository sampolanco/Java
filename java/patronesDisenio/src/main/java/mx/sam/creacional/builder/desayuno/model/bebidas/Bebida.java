package mx.sam.creacional.builder.desayuno.model.bebidas;

import mx.sam.creacional.builder.desayuno.model.ElementoMenu;
import mx.sam.creacional.builder.desayuno.model.empaquetado.Botella;

public class Bebida  extends ElementoMenu{
	public Bebida() {
		this.setEmpaquetado(new Botella());
	}
}
