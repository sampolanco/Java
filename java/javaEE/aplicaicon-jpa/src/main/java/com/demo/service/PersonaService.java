package com.demo.service;

import javax.ejb.Local;

import com.demo.model.Persona;

@Local
public interface PersonaService {
	Persona buscarPersonaPorNombre(String nombre);
}
