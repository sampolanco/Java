package com.demo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demo.model.Persona;
import com.demo.model.PersonaDAO;
import com.demo.model.PersonaDAOImpl;

@Stateless
public class PersonaServiceImpl implements PersonaService{
	PersonaDAO personaDAO;
	@PersistenceContext(unitName="aplicacionjpaPU")
	EntityManager em;
	
	public PersonaServiceImpl() {}
	
	@Inject
	public PersonaServiceImpl(PersonaDAO personaDAO) {
		this.personaDAO=personaDAO;
	}
	
	static Logger log=LogManager.getLogger(PersonaDAOImpl.class);

	@Override
	public List<Persona> findAll() {
		return personaDAO.findAll();
	}
	@Override
	public Persona findById(Integer id) {
		return personaDAO.findById(id);
	}
	@Override
	public Persona findByNombre(String nombre) {
		return personaDAO.findByNombre(nombre);
	}
	@Override
	public boolean insert(Persona persona) {
		return personaDAO.insert(persona);
	}
	@Override
	public boolean update(Persona persona) {
		return personaDAO.update(persona);
	}
	@Override
	public boolean delete(Persona persona) {
		return personaDAO.delete(persona);
	}
	@Override
	public void insertDeletePersonaTransaccion(Persona persona, boolean generarError) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		try {
			insert(persona);
			
			List<Persona> lista=this.findAll();
			Persona personaModificar=null;
			if(lista.size()>1) {
				personaModificar=lista.get(lista.size()-1);
				personaModificar.setNombre("Nombre Modificado DAOImpl");
				this.update(personaModificar);
			}
			if(generarError) {
				throw new RuntimeException("Rollback manual");
			}

			tx.commit();
		}
		catch(Exception e) {
			log.info("Se hace rollback de transaccion");
			tx.rollback();
			e.printStackTrace();
		}
		finally {

		}
	}

}
