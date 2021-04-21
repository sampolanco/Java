package com.sam.microservicio.manipulararreglo.ordenarLista.configuracion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.sam.microservicio.manipulararreglo.ordenarLista.dto.ElementoLista;

//@FeignClient(name = "repositorio",url ="http://localhost:8090/lista")
@FeignClient(name = "repositorio")
public interface RepositorioProxy {
	@GetMapping(value="/lista")
	public ElementoLista[] getElementosLista();
}
