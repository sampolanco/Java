package com.sam.microservicio.manipulararreglo.repositorio.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sam.microservicio.manipulararreglo.repositorio.dto.ElementoLista;

@RestController("lista/")
@RequestMapping(path="lista/")
public class ListaController {
	@Autowired
	private Environment environment;
	
	@GetMapping
	public List<ElementoLista> getElementosLista(){
		String puerto=environment.getProperty("local.server.port");
		List<ElementoLista> lista=new ArrayList<ElementoLista>();
		lista.add(new ElementoLista(10,"amadeus",LocalDate.of(2020, 10, 10),puerto));
		lista.add(new ElementoLista(1,"samuel",LocalDate.of(2001, 7, 20),puerto));
		lista.add(new ElementoLista(13,"naomi",LocalDate.of(2001, 7, 15),puerto));
		lista.add(new ElementoLista(5,"ale",LocalDate.of(2005, 10, 3),puerto));
		return lista;
	}

}
