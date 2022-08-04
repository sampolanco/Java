package mx.sam.requesthttp.libreriasspring.WebClient;

import java.io.IOException;
import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.sam.requesthttp.ObjetoGet;

public class Peticiones {
	String urlBase = "https://httpbin.org/get";

	public void peticionGetSimple() throws IOException {
		WebClient client = WebClient.builder()
				  .baseUrl(urlBase)
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				  .build();
		
		RequestHeadersUriSpec<?> uriSpec = client.get();
		RequestBodySpec bodySpec = uriSpec.uri("");



		System.out.println("Spring WebClient");
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