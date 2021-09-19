package com.demo.service;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.Direccion;

@Local
public interface DireccionService {
	 List<Direccion> findAll();
	 Direccion findById(Integer id);
	 List<Direccion> findByCiudad(String ciudad);
	 List<Object[]> findAllIdCiudad();
	 List<Object[]> findAllIdDireccion();
	 List<Direccion> findAllCriteria();
	 List<Direccion> findCriteria(Direccion filtro);
	 Object[] findMinMaxCount();
	 boolean insert(Direccion persona);
}
