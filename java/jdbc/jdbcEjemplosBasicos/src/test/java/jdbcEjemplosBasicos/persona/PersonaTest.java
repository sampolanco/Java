package jdbcEjemplosBasicos.persona;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;

import jdbcEjemplosBasicos.jdbc.PersonaJDBC;
import jdbcEjemplosBasicos.model.Persona;

public class PersonaTest {

	@Test
	public void insertarPersonaSinDireccion() {
		System.out.println("insertarPersona");
		final Integer idDireccion=null;
		int personasAntes=imprimirPersonas("antes");
		Persona persona=new Persona("persona","nueva",20);
		PersonaJDBC.insert(persona,idDireccion);
		int personasDespues=imprimirPersonas("despues");	
		assertNotEquals(personasDespues, personasAntes);
	}
	@Test
	public void insertarPersonaConDireccion() {
		System.out.println("insertarPersonaConDireccion");
		final Integer idDireccion=1;
		int personasAntes=imprimirPersonas("antes");
		Persona persona=new Persona("persona","nueva",20);
		PersonaJDBC.insert(persona,idDireccion);
		int personasDespues=imprimirPersonas("despues");		
		assertNotEquals(personasDespues, personasAntes);
	}
	@Test
	public void insertarPersonaConDireccionNoexistente() {
		System.out.println("insertarPersonaConDireccionNoexistente");
		final Integer idDireccion=-1;
		int personasAntes=imprimirPersonas("antes");
		Persona persona=new Persona("persona","nueva",20);;
		PersonaJDBC.insert(persona,idDireccion);
		int personasDespues=imprimirPersonas("despues");		
		assertEquals(personasDespues, personasAntes);
	}
	private int imprimirPersonas(String mensaje) {
		List<Persona> listaPersonas=PersonaJDBC.findAll();
		System.out.println("----Imprimiendo personas "+mensaje);
		for(Persona persona: listaPersonas) {
			System.out.println(persona);
			System.out.println(persona.getDireccion());
		}
		return listaPersonas.size();
	}

}
