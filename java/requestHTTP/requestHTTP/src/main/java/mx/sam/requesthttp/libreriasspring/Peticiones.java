package mx.sam.requesthttp.libreriasspring;

import java.io.IOException;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.sam.requesthttp.ObjetoGet;

public class Peticiones {
	String urlBase = "https://httpbin.org/get";

	public void peticionGetSimple() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(urlBase, String.class);

		System.out.println("Spring");
		System.out.println("Contenido:" + response.getBody());
		System.out.println("contentType:" + response.getHeaders().getContentType());
		System.out.println("Cabeceras: " + response.getHeaders());
	}

	public void peticionGetMapeadoJson() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(urlBase, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode origin = root.path("origin");

		System.out.println("Spring Json");
		System.out.println("Origin desde Arbol:" + origin);
		
		ObjetoGet objget = mapper.readValue(response.getBody(),ObjetoGet.class);
		System.out.println("Origin desde Objeto:" + objget.getOrigin());
		

	}


}