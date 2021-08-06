package jdbcEjemplosBasicos.persona;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import jdbcEjemplosBasicos.jdbc.PersonaJDBC;
import jdbcEjemplosBasicos.model.Persona;

public class TransaccionPersona {

	@Test
	public void testTransaccionExitosa() {
		System.out.println("testTransaccionExitosa");
		boolean generarError=false;
		List<Persona> listaPersonasAntes=PersonaJDBC.findAll();
		imprimirPersonas(listaPersonasAntes);
		Persona nuevaPersona=new Persona("persona","nueva",20);
		PersonaJDBC.insertDeletePersonaTransaccion(nuevaPersona,generarError);
		List<Persona> listaPersonasDespues=PersonaJDBC.findAll();
		imprimirPersonas(listaPersonasDespues);	
		assertNotEquals(listaPersonasAntes.size(), listaPersonasDespues.size());
	}
	@Test
	public void testTransaccionFallida() {
		System.out.println("testTransaccionFallida");
		boolean generarError=true;
		List<Persona> listaPersonasAntes=PersonaJDBC.findAll();
		imprimirPersonas(listaPersonasAntes);
		Persona nuevaPersona=new Persona("persona","nueva",20);
		PersonaJDBC.insertDeletePersonaTransaccion(nuevaPersona,generarError);
		List<Persona> listaPersonasDespues=PersonaJDBC.findAll();
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
