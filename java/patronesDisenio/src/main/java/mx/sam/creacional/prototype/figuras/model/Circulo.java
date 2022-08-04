package mx.sam.creacional.prototype.figuras.model;

public class Circulo extends Figura{

	private String radio;

	public Circulo(Circulo figura) {
		super(figura);
		this.radio=figura.radio;
	}
	
	@Override
	Figura clonar() {
		return new Circulo(this);
	}

	public String getRadio() {
		return radio;
	}

}
