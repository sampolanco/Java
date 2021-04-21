package com.sam.microservicio.manipulararreglo.ordenarLista.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.sam.microservicio.manipulararreglo.ordenarLista.configuracion.proxy.RepositorioProxy;
import com.sam.microservicio.manipulararreglo.ordenarLista.dto.ElementoLista;


@RestController
@RequestMapping(path="ordenar-lista")
public class OrdenarListaController {
	private String urlListaController="http://localhost:8090/lista";
	@Autowired
	private RepositorioProxy repositorioProxy;
	
	@GetMapping
	public List<ElementoLista> getListaOrdenada(){
		List<ElementoLista> lista=obtenerListaDesdeServicio();
		return lista;	
	}
	@GetMapping(value="/texto")
	public List<ElementoLista> getListaOrdenadaTexto(){
		List<ElementoLista> lista=obtenerListaDesdeServicioProxy();
		lista.sort((x,y)->{
			return x.getTexto().compareTo(y.getTexto());
		});
		return lista;
	}
	@GetMapping(value="/numero")
	public List<ElementoLista> getListaOrdenadaNumero(){
		List<ElementoLista> lista=obtenerListaDesdeServicioProxy();
		lista.sort((x,y)->{
			return x.getNumero()-y.getNumero();
		});
		return lista;
	}
	
	private List<ElementoLista> obtenerListaDesdeServicio() {
		List<ElementoLista> lista;
		ResponseEntity<ElementoLista[]> response=
				new RestTemplate().getForEntity(urlListaController, ElementoLista[].class);
		ElementoLista[] listaArray=response.getBody();
		lista=Arrays.asList(listaArray);
		return lista;
	}
	private List<ElementoLista> obtenerListaDesdeServicioProxy() {
		List<ElementoLista> lista;
		ElementoLista[] listaArray=repositorioProxy.getElementosLista();
		lista=Arrays.asList(listaArray);
		return lista;
	}
}
