package mx.com.springBootJWT.model;

public class Usuario {


	Integer id;
	String nombre;
	String password;
	String correo;
	String telefono;
	
	public Usuario() {};
	public Usuario(Integer id, String nombre, String password, String correo, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.correo = correo;
		this.telefono = telefono;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
