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
		DireccionService direccionService = new DireccionServiceImpl(new DireccionDAOImpl());
		Direccion direccion=new Direccion("Maza","acueducto",21);
		direccionService.insert(direccion);
		pintarDirecciones();
		assertNotNull(direccion.getId());
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
