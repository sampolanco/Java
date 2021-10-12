package com.demo.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Stateless
public class DireccionDAOImpl implements DireccionDAO{
	
	static Logger log=LogManager.getLogger(DireccionDAOImpl.class);

	@Override
	public List<Direccion> findAll() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		List<Direccion> personas=em.createNamedQuery("Direccion.findAll",Direccion.class).getResultList();
		return personas;
	}
	@Override
	public Direccion findById(Integer id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		Direccion persona=em.find(Direccion.class, id);
		return persona;
	}
	@Override
	public boolean insert(Direccion direccion) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(direccion);
		tx.commit();
		em.close();
		emf.close();
		return true;
	}
}
