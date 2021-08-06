package com.demo.persona;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.demo.model.Persona;


public class InsertPersona {
	static Logger log=LogManager.getRootLogger();

	@Test
	public void test() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		
		List<Persona> listaPersonasAntes;
		List<Persona> listaPersonasDespues;

		tx.begin();
		
		
		//listaPersonasAntes=PersonaJDBC.findAll();
		//imprimirPersonas(listaPersonasAntes);
		Persona nuevaPersona=new Persona("persona","nueva",30);
		System.out.println("Antes de persistir: "+nuevaPersona);
		log.debug("Antes de persistir: "+nuevaPersona);

		em.persist(nuevaPersona);

		//listaPersonasDespues=PersonaJDBC.findAll();
		//imprimirPersonas(listaPersonasDespues);	
		
		tx.commit();
		log.debug("Despues de persistir: "+nuevaPersona);
		System.out.println("Despues de persistir: "+nuevaPersona);
		em.close();
	}
	
	private void imprimirPersonas(List<Persona> listaPersonas) {
		System.out.println("----Imprimiendo personas");
		for(Persona persona: listaPersonas) {
			System.out.println(persona);
		}
	}

}
