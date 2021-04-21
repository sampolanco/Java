package com.sam.microservicio.manipulararreglo.ordenarLista.dto;

import java.time.LocalDate;

public class ElementoLista {
	private int numero;
	private String texto;
	private LocalDate fecha;
	private String puerto;
	
	public ElementoLista() {
	}
	public ElementoLista(int numero,String texto,LocalDate fecha,String puerto) {
		this.numero=numero;
		this.texto=texto;
		this.fecha=fecha;
		this.puerto=puerto;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
}
