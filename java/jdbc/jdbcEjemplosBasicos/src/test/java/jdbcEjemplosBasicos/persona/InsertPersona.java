package jdbcEjemplosBasicos.persona;


import java.util.List;

import org.junit.Test;

import jdbcEjemplosBasicos.jdbc.PersonaJDBC;
import jdbcEjemplosBasicos.model.Persona;

public class InsertPersona {

	@Test
	public void test() {
		List<Persona> listaPersonas;
		listaPersonas=PersonaJDBC.findAll();
		imprimirPersonas(listaPersonas);
		Persona nuevaPersona=new Persona("persona","nueva",20);
		PersonaJDBC.insert(nuevaPersona);
		listaPersonas=PersonaJDBC.findAll();
		imprimirPersonas(listaPersonas);	
	}
	
	private void imprimirPersonas(List<Persona> listaPersonas) {
		System.out.println("----Imprimiendo personas");
		for(Persona persona: listaPersonas) {
			System.out.println(persona);
		}
	}

}
