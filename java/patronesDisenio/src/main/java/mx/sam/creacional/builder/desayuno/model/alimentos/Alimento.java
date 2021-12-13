package mx.sam.creacional.builder.desayuno.model.alimentos;

import mx.sam.creacional.builder.desayuno.model.ElementoMenu;
import mx.sam.creacional.builder.desayuno.model.empaquetado.Bolsa;

public class Alimento extends ElementoMenu{
	public Alimento() {
		this.setEmpaquetado(new Bolsa());
	}
}
