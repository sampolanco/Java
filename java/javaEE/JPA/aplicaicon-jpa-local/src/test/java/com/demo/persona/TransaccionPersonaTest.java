package com.demo.persona;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.demo.model.Persona;
import com.demo.model.PersonaDAOImpl;
import com.demo.service.PersonaService;
import com.demo.service.PersonaServiceImpl;

public class TransaccionPersonaTest {

	@Test
	public void testTransaccionExitosa() {
		System.out.println("testTransaccionExitosa");
		PersonaService personaService = new PersonaServiceImpl(new PersonaDAOImpl());
		boolean generarError=false;
		List<Persona> listaPersonasAntes=personaService.findAll();
		imprimirPersonas(listaPersonasAntes);
		Persona nuevaPersona=new Persona("persona","nueva",20);
		personaService.insertDeletePersonaTransaccion(nuevaPersona,generarError);
		List<Persona> listaPersonasDespues=personaService.findAll();
		imprimirPersonas(listaPersonasDespues);	
		assertNotEquals(listaPersonasAntes.size(), listaPersonasDespues.size());
	}
	@Test
	public void testTransaccionFallida() {
		System.out.println("testTransaccionFallida");
		PersonaService personaService = new PersonaServiceImpl(new PersonaDAOImpl());
		boolean generarError=true;
		List<Persona> listaPersonasAntes=personaService.findAll();
		imprimirPersonas(listaPersonasAntes);
		Persona nuevaPersona=new Persona("persona","nueva",20);
		personaService.insertDeletePersonaTransaccion(nuevaPersona,generarError);
		List<Persona> listaPersonasDespues=personaService.findAll();
		imprimirPersonas(listaPersonasDespues);	
		assertEquals(listaPersonasAntes.size(), listaPersonasDespues.size());
	}
	
	private void imprimirPersonas(List<Persona> listaPersonas) {
		System.out.println("----Imprimiendo personas");
		for(Persona persona: listaPersonas) {
			System.out.println(persona);
		}
	}

}
