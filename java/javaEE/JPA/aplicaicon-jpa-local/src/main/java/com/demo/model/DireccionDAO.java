package com.demo.model;

import java.util.List;


public interface DireccionDAO {
	 List<Direccion> findAll();
	 Direccion findById(Integer id);
	 boolean insert(Direccion persona);
}
