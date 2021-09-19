package com.demo.direccion;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.demo.model.Direccion;
import com.demo.model.DireccionDAOImpl;
import com.demo.service.DireccionService;
import com.demo.service.DireccionServiceImpl;


public class DireccionTest {
	static Logger log=LogManager.getRootLogger();

	@Test
	public void insertDireccion() {
		log.info("insertDireccion");
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		Direccion direccion=new Direccion("Maza","acueducto",21);
		direccionService.insert(direccion);
		pintarDirecciones();
		assertNotNull(direccion.getId());
	}
	
	@Test
	public void buscarDireccionPorId() {
		log.info("buscarDireccionPorId");
		Integer id=1;
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		Direccion direccion=direccionService.findById(id);
		log.info(direccion);
		assertNotNull(direccion.getId());
	}
	
	@Test
	public void buscarDireccionPorCiudad() {
		log.info("buscarDireccionPorCiudad");
		String ciudad="Maza";
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		List<Direccion> direcciones=direccionService.findByCiudad(ciudad);
		for(Direccion direccion:direcciones) {
			log.info(direccion);
		}
	}
	@Test
	public void buscarAllIdCiudad() {
		log.info("buscarAllIdCiudad");
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		List<Object[]> direcciones=direccionService.findAllIdCiudad();
		for(Object[] direccion:direcciones) {
			log.info(direccion[0]);
		}
	}
	@Test
	public void findAllIdDireccion() {
		log.info("findAllIdDireccion");
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		List<Object[]> direcciones=direccionService.findAllIdDireccion();
		for(Object[] direccion:direcciones) {
			log.info("id:"+direccion[0]);
			log.info("direccion:"+direccion[1]);
		}
	}
	@Test
	public void findMinMaxCount() {
		log.info("findMinMaxCount");
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		Object[] datos=direccionService.findMinMaxCount();
		for(Object dato:datos) {
			log.info(dato);
		}
	}
	@Test
	public void findAllCriteria() {
		log.info("findAllCriteria");
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		List<Direccion> direcciones=direccionService.findAllCriteria();
		for(Direccion direccion:direcciones) {
			log.info(direccion);
		}
	}
	@Test
	public void findCriteria() {
		log.info("findCriteria");
		Direccion filtro =new Direccion();
		filtro.setId(1);
		//filtro.setCalle("ac");
		filtro.setCiudad("Ma");
		filtro.setNumero(21);
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		List<Direccion> direcciones=direccionService.findCriteria(filtro);
		for(Direccion direccion:direcciones) {
			log.info(direccion);
		}
	}
	private void pintarDirecciones() {
		log.info("pintarDirecciones");
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		List<Direccion> direcciones=direccionService.findAll();
		for(Direccion direccion:direcciones) {
			log.info(direccion);
		}
	}

}
