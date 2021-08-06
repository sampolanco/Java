package com.demo.service;

import javax.ejb.Stateless;

import com.demo.model.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaService{

	@Override
	public Persona buscarPersonaPorNombre(String nombre) {
		Persona persona=new Persona();
		persona.setNombre(nombre);
		persona.setApellido("Polanco");
		persona.setEdad(18);
		return persona;
	}

}
