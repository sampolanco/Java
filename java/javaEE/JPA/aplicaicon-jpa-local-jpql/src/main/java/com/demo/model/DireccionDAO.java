package com.demo.model;

import java.util.List;


public interface DireccionDAO {
	 List<Direccion> findAll();
	 Direccion findById(Integer id);
	 List<Direccion> findByCiudad(String ciudad);
	 List<Object[]> findAllIdCiudad();
	 List<Object[]> findAllIdDireccion();
	 Object[] findMinMaxCount();

	 boolean insert(Direccion persona);
}
