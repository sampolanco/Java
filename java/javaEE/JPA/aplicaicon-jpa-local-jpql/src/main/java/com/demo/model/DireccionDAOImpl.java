package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	public 
	List<Direccion> findAllCriteria(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Direccion> criteriaQuery=cb.createQuery(Direccion.class);
		
		//Elaboracion de consulta
		Root<Direccion> direccionAll=criteriaQuery.from(Direccion.class);
		criteriaQuery.select(direccionAll);
		
		Query query =em.createQuery(criteriaQuery);
		List<Direccion> lista=query.getResultList();
		return lista;
	}
	@Override
	public 
	List<Direccion> findCriteria(Direccion filtro){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacionjpaPU");
		EntityManager em=emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Direccion> criteriaQuery=cb.createQuery(Direccion.class);
		
		//Elaboracion de consulta
		Root<Direccion> direccionAll=criteriaQuery.from(Direccion.class);
		List<Predicate> criterios=getCriterios(filtro,cb,direccionAll);
		
		criteriaQuery.select(direccionAll);
		criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
		
		Query query =em.createQuery(criteriaQuery);
		if(filtro.getId()!=null)
			query.setParameter("id", filtro.getId());
		if(filtro.getCalle()!=null)
			query.setParameter("calle", "%"+filtro.getCalle()+"%");
		if(filtro.getCiudad()!=null)
			query.setParameter("ciudad","%"+ filtro.getCiudad()+"%");
		if(filtro.getNumero()!=null)
			query.setParameter("numero", filtro.getNumero());
		List<Direccion> lista=query.getResultList();
		return lista;
	}
	List<Predicate> getCriterios(Direccion filtro,CriteriaBuilder cb,Root<Direccion> direccionAll){
		List<Predicate> filtros=new ArrayList<Predicate>();
		if(filtro.getId()!=null) {
			ParameterExpression<Integer> expresion=cb.parameter(Integer.class,"id");
			filtros.add(cb.equal(direccionAll.get("id"), expresion));
		}
		if(filtro.getCalle()!=null) {
			ParameterExpression<String> expresion=cb.parameter(String.class,"calle");
			filtros.add(cb.like(direccionAll.get("calle"), expresion));
		}
		if(filtro.getCiudad()!=null) {
			ParameterExpression<String> expresion=cb.parameter(String.class,"ciudad");
			filtros.add(cb.like(direccionAll.get("ciudad"), expresion));
		}
		if(filtro.getNumero()!=null) {
			ParameterExpression<Integer> expresion=cb.parameter(Integer.class,"numero");
			filtros.add(cb.equal(direccionAll.get("numero"), expresion));
		}
		return filtros;
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
