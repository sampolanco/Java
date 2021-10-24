package com.demo.service;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.Direccion;

@Local
public interface DireccionService {
	 List<Direccion> findAll();
	 Direccion findById(Integer id);
	 boolean insert(Direccion persona);
}
