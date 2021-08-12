package jdbcEjemplosBasicos.model;

import java.io.Serializable;


public class Direccion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String ciudad;
	private String calle;
	private Integer numero;
	
	
	public Direccion() {}
	public Direccion(String ciudad, String calle, Integer numero) {
		super();
		this.ciudad = ciudad;
		this.calle = calle;
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", ciudad=" + ciudad + ", calle=" + calle + ", numero=" + numero + "]";
	}
}
