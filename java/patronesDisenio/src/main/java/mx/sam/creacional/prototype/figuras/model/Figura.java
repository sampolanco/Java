package mx.sam.creacional.prototype.figuras.model;

public abstract class Figura{
	private int x;
	private int y;
	protected String color;
	
	public Figura(Figura figura){
		this.x=figura.x;
		this.y=figura.y;
		this.color=figura.color;
	}
	abstract Figura clonar();

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getColor() {
		return color;
	}

	
}
