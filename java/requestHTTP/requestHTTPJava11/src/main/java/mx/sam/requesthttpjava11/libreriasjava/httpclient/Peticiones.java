package mx.sam.requesthttpjava11.libreriasjava.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import mx.sam.requesthttpjava11.libreriasjava.httpclient.utils.JsonBodyHandler;
import mx.sam.requesthttpjava11.libreriasjava.httpclient.utils.ObjetoBody;

public class Peticiones {
	String urlBase = "https://httpbin.org/get";

	public void peticionGetSimple() throws IOException, InterruptedException {
		// create a client
		HttpClient client = HttpClient.newHttpClient();

		// create a request
		HttpRequest request = HttpRequest.newBuilder(
		       URI.create(urlBase))
		   .header("accept", "application/json")
		   .build();
		
		HttpResponse<String> response = client.send(request,BodyHandlers.ofString());
		System.out.println("body: "+ response.body());
		System.out.println("header: "+ response.headers());

		//HttpResponse<Supplier<ObjetoBody>> response = client.send(request, new JsonBodyHandler<>(ObjetoBody.class));
		//System.out.println(response.body().get().title);
	}
	public void peticionGetSimpleAsincrona() throws IOException, InterruptedException, ExecutionException {
		// create a client
		HttpClient client = HttpClient.newHttpClient();

		// create a request
		HttpRequest request = HttpRequest.newBuilder(
		       URI.create(urlBase))
		   .header("accept", "application/json")
		   .build();
		
		Future<HttpResponse<String>> responseFuture=client.sendAsync(request,BodyHandlers.ofString());
		
		HttpResponse<String> response=responseFuture.get();
		System.out.println("body: "+ response.body());
		System.out.println("header: "+ response.headers());

	}
}
