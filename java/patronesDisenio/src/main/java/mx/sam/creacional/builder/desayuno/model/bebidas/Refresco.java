package mx.sam.creacional.builder.desayuno.model.bebidas;

public class Refresco extends Bebida{
	private String marca;
	
	public Refresco(String marca) {
		this.setPrecio(20);
		this.setNombre("Refresco de "+marca);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
