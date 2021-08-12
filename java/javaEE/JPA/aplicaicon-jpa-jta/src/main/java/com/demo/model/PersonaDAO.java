package com.demo.model;

import java.util.List;


public interface PersonaDAO {
	 List<Persona> findAll();
	 Persona findById(Integer id);
	 Persona findByNombre(String nombre);
	 boolean insert(Persona persona);
	 boolean update(Persona persona);
	 boolean delete(Persona persona);
}
