package com.demo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demo.model.Direccion;
import com.demo.model.DireccionDAO;
import com.demo.model.DireccionDAOImpl;

@Stateless
public class DireccionServiceImpl implements DireccionService{
	
	DireccionDAO direccionDAO;
	
	public DireccionServiceImpl() {}
	
	@Inject
	public DireccionServiceImpl(DireccionDAO direccionDAO) {
		this.direccionDAO=direccionDAO;
	}
	
	static Logger log=LogManager.getLogger(DireccionDAOImpl.class);

	@Override
	public List<Direccion> findAll() {
		return direccionDAO.findAll();
	}
	@Override
	public Direccion findById(Integer id) {
		return direccionDAO.findById(id);
	}
	@Override
	public List<Direccion> findByCiudad(String ciudad) {
		return direccionDAO.findByCiudad(ciudad);
	}
	@Override
	public List<Object[]> findAllIdCiudad() {
		return direccionDAO.findAllIdCiudad();
	}
	@Override
	public List<Object[]> findAllIdDireccion(){
		return direccionDAO.findAllIdDireccion();
	 }
	 @Override
	 public Object[] findMinMaxCount() {
		return direccionDAO.findMinMaxCount();
	 }
	@Override
	public 
	List<Direccion> findAllCriteria(){
		return direccionDAO.findAllCriteria();
	}
	@Override
	public 
	List<Direccion> findCriteria(Direccion filtro){
		return direccionDAO.findCriteria(filtro);
	}
	@Override
	public boolean insert(Direccion persona) {
		return direccionDAO.insert(persona);
	}

}
