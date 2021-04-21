package com.sam.microservicio.serviciolimites.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.microservicio.serviciolimites.configuration.LimiteConfiguration;
import com.sam.microservicio.serviciolimites.dto.LimiteDTO;

@RestController
@RequestMapping("limite/")
public class LimiteController {
	@Autowired
	LimiteConfiguration limiteConfiguration;
	
	@GetMapping("")
	private LimiteDTO  getLimite() {
		LimiteDTO limite=new LimiteDTO();
		limite.setMinimo(limiteConfiguration.getMinimo());
		limite.setMaximo(limiteConfiguration.getMaximo());
		return  limite;
	}
}
