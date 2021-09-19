package com.demo.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Stateless
public class DireccionDAOImpl implements DireccionDAO{
	
	static Logger log=LogManager.getLogger(DireccionDAOImpl.class);

	@Override
	public List<Direccion> findAll() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		String jpql="select d from Direccion d";
		List<Direccion> direcciones=em.createQuery(jpql).getResultList();
		return direcciones;
	}
	@Override
	public Direccion findById(Integer id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();

		String jpql="select d from Direccion d where d.id="+id;
		Direccion direccion=(Direccion)em.createQuery(jpql).getSingleResult();
		return direccion;
	}
	@Override
	public List<Direccion> findByCiudad(String ciudad) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		String jpql="select d from Direccion d where upper(d.ciudad) like upper(:ciudad) order by d.ciudad desc, d.calle desc";
		Query query=em.createQuery(jpql);
		query.setParameter("ciudad", "%"+ciudad+"%");
		List<Direccion> direcciones=query.getResultList();
		return direcciones;
	}
	@Override
	public List<Object[]> findAllIdCiudad() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		String jpql="select d.id,d.ciudad from Direccion d where d.id between 1 and 10";
		List<Object[]> direcciones=em.createQuery(jpql).getResultList();
		return direcciones;
	}	
	@Override
	public List<Object[]> findAllIdDireccion() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		String jpql="select d.id,d from Direccion d";
		List<Object[]> direcciones=em.createQuery(jpql).getResultList();
		return direcciones;
	}
	@Override
	public Object[] findMinMaxCount() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		String jpql="select min(d.id),max(d.id),count(d.id) from Direccion d";
		List<Object[]> datos=em.createQuery(jpql).getResultList();
		return datos.get(0);
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
