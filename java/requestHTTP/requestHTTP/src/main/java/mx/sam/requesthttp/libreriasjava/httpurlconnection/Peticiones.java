package mx.sam.requesthttp.libreriasjava.httpurlconnection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Peticiones {
	String urlBase = "https://httpbin.org/get";

	public void peticionGetSimple() throws IOException {
		URL url = new URL(urlBase);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		leerCuerpo(con);
	}
	public void peticionGetConParametros() throws IOException {
		URL url = new URL(urlBase);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		
		Map<String, String> parameters = new HashMap<String,String>();
		parameters.put("param1", "val");

		con.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParametroStringBuilder.getParamsString(parameters));
		out.flush();
		out.close();

		
		leerCuerpo(con);
	}
	 
	private void leerCuerpo(HttpURLConnection con) throws IOException {
		String contentType = con.getHeaderField("Content-Type");
		int status = con.getResponseCode();
		Reader streamReader = null;

		if (status > 299) {
		    streamReader = new InputStreamReader(con.getErrorStream());
			StringBuffer content = new StringBuffer();
			int data = streamReader.read();  
			while (data!=-1) {
				data = streamReader.read();  
				content.append((char) data);

			}
			System.out.println("Error:" + content);

		} else {
		    streamReader = new InputStreamReader(con.getInputStream());
			BufferedReader in = new BufferedReader(streamReader);
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			System.out.println("Contenido:" + content);
			System.out.println("contentType:" + contentType);
			System.out.println("Cabeceras: " + leerCabeceras(con));
		}
	}
	private String leerCabeceras(HttpURLConnection con) {
		StringBuffer fullResponseBuilder = new StringBuffer();
		con.getHeaderFields().entrySet().stream()
		  .filter(entry -> entry.getKey() != null)
		  .forEach(entry -> {
		      fullResponseBuilder.append(entry.getKey()).append(": ");
		      List headerValues = entry.getValue();
		      Iterator it = headerValues.iterator();
		      if (it.hasNext()) {
		          fullResponseBuilder.append(it.next());
		          while (it.hasNext()) {
		              fullResponseBuilder.append(", ").append(it.next());
		          }
		      }
		      fullResponseBuilder.append("\n");
		});
		return fullResponseBuilder.toString();
	}
	
}