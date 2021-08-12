package com.demo.service;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.Persona;

@Local
public interface PersonaService {
	 List<Persona> findAll();
	 Persona findById(Integer id);
	 Persona findByNombre(String nombre);
	 boolean insert(Persona persona);
	 boolean update(Persona persona);
	 boolean delete(Persona persona);
	 void insertDeletePersonaTransaccion(Persona persona,boolean generarError);
}
