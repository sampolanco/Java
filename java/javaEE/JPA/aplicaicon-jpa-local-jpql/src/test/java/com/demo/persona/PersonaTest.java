package com.demo.persona;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.demo.model.Direccion;
import com.demo.model.DireccionDAOImpl;
import com.demo.model.Persona;
import com.demo.model.PersonaDAOImpl;
import com.demo.service.DireccionService;
import com.demo.service.DireccionServiceImpl;
import com.demo.service.PersonaService;
import com.demo.service.PersonaServiceImpl;

public class PersonaTest {
	static Logger log=LogManager.getRootLogger();

	@Test
	public void testEntityMannager() {
		log.info("testEntityMannager");
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Persona persona=new Persona("persona","nueva",30);

		log.info("Antes de persistir: "+persona);
		em.persist(persona);
		log.info("Despues de persistir: "+persona);
		
		tx.commit();
		em.close();
		
		assertNotNull(persona.getId());
	}

	@Test
	public void testInsertarSinDireccion() {
		log.info("testInsertarSinDireccion");
		PersonaService personaService = new PersonaServiceImpl(new PersonaDAOImpl());
		Persona persona=new Persona("persona","nueva",30);
		log.info("Antes de persistir: "+persona);
		personaService.insert(persona);
		log.info("Despues de persistir: "+persona);
		assertNotNull(persona.getId());
	}
	
	@Test
	public void testInsertarConDireccion() {
		log.info("testInsertarConDireccion");
		PersonaService personaService = new PersonaServiceImpl(new PersonaDAOImpl());
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		Direccion direccion=direccionService.findById(1);
		Persona persona=new Persona("persona","nueva",40);
		persona.setDireccion(direccion);
		log.info("Antes de persistir: "+persona);
		personaService.insert(persona);
		log.info("Despues de persistir: "+persona);
		imprimirPersonas("despues");
		assertNotNull(persona.getId());
	}
	
	private int imprimirPersonas(String mensaje) {
		PersonaService personaService = new PersonaServiceImpl(new PersonaDAOImpl());
		List<Persona> listaPersonas=personaService.findAll();
		System.out.println("----Imprimiendo personas "+mensaje);
		for(Persona persona: listaPersonas) {
			System.out.println(persona);
			System.out.println(persona.getDireccion());
		}
		return listaPersonas.size();
	}
}
