package com.demo.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Stateless
public class PersonaDAOImpl implements PersonaDAO{
	
	static Logger log=LogManager.getLogger(PersonaDAOImpl.class);

	@Override
	public List<Persona> findAll() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		List<Persona> personas=em.createNamedQuery("Persona.findAll",Persona.class).getResultList();
		return personas;
	}
	@Override
	public Persona findById(Integer id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		Persona persona=em.find(Persona.class, id);
		return persona;
	}
	@Override
	public Persona findByNombre(String nombre) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select p from Persona p where p.nombre=:nombre order by p.nombre");
		query.setParameter("nombre", nombre);
		Persona personaResult=null;
		try {
			personaResult=(Persona) query.getSingleResult();
		}
		catch(Exception e) {
			personaResult=new Persona();
		}
		return personaResult;
	}
	@Override
	public boolean insert(Persona persona) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		em.persist(persona);
		return true;
	}
	@Override
	public boolean update(Persona persona) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		em.merge(persona);
		return true;
	}
	@Override
	public boolean delete(Persona persona) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		em.merge(persona);
		em.remove(persona);
		return true;
	}

}
