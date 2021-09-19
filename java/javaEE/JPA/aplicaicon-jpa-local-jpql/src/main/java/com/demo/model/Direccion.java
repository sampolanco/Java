package com.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Direccion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="ciudad")
	private String ciudad;
	@Column(name="calle")
	private String calle;
	@Column(name="numero")
	private Integer numero;
	
	@OneToMany(mappedBy="direccion")
	private List<Persona> personas;
	
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
	
	public List<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", ciudad=" + ciudad + ", calle=" + calle + ", numero=" + numero + "]";
	}
}
