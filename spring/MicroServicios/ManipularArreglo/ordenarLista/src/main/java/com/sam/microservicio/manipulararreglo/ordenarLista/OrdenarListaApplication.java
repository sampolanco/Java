package com.sam.microservicio.manipulararreglo.ordenarLista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;;


@SpringBootApplication
@EnableFeignClients
public class OrdenarListaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdenarListaApplication.class, args);
	}

}
