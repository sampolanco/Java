package com.demo.persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.demo.model.Persona;
import com.demo.model.PersonaDAOImpl;
import com.demo.service.PersonaService;
import com.demo.service.PersonaServiceImpl;


public class InsertPersona {
	static Logger log=LogManager.getRootLogger();

	@Test
	public void testEntityMannager() {
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
	}

	@Test
	public void testUtilizandoService() {
		PersonaService personaService = new PersonaServiceImpl(new PersonaDAOImpl());
		Persona persona=new Persona("persona","nueva",30);
		log.info("Antes de persistir: "+persona);
		personaService.insert(persona);
		log.info("Despues de persistir: "+persona);
	}
	

}
