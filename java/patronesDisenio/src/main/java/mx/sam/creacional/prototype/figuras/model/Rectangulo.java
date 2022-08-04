package mx.sam.creacional.prototype.figuras.model;

public class Rectangulo extends Figura {
	private String ancho;
	private String alto;
	
	public Rectangulo(Rectangulo figura) {
		super(figura);
		this.ancho=figura.ancho;
		this.alto=figura.alto;
	}
	
	@Override
	Figura clonar() {
		return new Rectangulo(this);
	}

	public String getAncho() {
		return ancho;
	}


	public String getAlto() {
		return alto;
	}
	

}
