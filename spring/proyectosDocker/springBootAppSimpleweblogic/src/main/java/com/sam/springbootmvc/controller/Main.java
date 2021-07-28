package com.sam.springbootmvc.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class Main {
	@RequestMapping({"","/index"})
	private String  get() {
		return "Accedí al get de index";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="")
	public String mensaje(@RequestBody String mensaje) {
		System.out.println(mensaje);
		return "Se procesó el mensaje "+mensaje;
	}
}
