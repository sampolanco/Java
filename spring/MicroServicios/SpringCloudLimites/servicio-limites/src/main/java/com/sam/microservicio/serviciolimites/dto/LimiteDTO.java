package com.sam.microservicio.serviciolimites.dto;

public class LimiteDTO {
	private int minimo;
	private int maximo;
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	
}
