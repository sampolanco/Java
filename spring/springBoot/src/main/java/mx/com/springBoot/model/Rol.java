package mx.com.springBoot.model;

public class Rol {


	Integer id;
	Integer idUsuiario;
	String descripcion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdUsuiario() {
		return idUsuiario;
	}
	public void setIdUsuiario(Integer idUsuiario) {
		this.idUsuiario = idUsuiario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
