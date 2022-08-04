package mx.sam.creacional.builder.desayuno.model.bebidas;

public class AguaSabor extends Bebida{
	private String sabor;
	
	public AguaSabor(String sabor) {
		super();		
		this.setPrecio(20);
		this.setNombre("Agua de "+sabor);
		this.sabor = sabor;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	
}
