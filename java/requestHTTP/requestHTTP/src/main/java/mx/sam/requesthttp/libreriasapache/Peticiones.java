package mx.sam.requesthttp.libreriasapache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Peticiones {
	String urlBase = "https://httpbin.org/get";

	public void peticionGetSimple() throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		try (CloseableHttpClient client = HttpClients.createDefault()) {

			HttpGet request = new HttpGet(urlBase);

			StringBuffer respuesta =client.execute(request, httpResponse -> {
				Reader streamReader = new InputStreamReader(httpResponse.getEntity().getContent());
				BufferedReader in = new BufferedReader(streamReader);
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				return content;
			});
			System.out.println(respuesta);

		}
	}

	public void peticionGetConParametros() throws IOException {

	}


}