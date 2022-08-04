Sin usar librerias de terceros
	java.net.HttpURLConnection
		Libreria mas antigua de java para hacer peticiones get
		Desventaja
			Es unn poco mas complejo de implementar
		Ventaja
			Funciona con versiones viejas de java
	java.net.http.HttpRequest
		Los BodyHandlers nos ayudan a recibir las peticiones
		Disponible a partir de java11
		Ventaja
			El código es mas facil de implementar
		
		



#Pagina para hacer pruebas
	https://httpbin.org/

referencias
https://www.baeldung.com/java-http-request
https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpResponse.BodyHandler.html
https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpResponse.BodyHandlers.html