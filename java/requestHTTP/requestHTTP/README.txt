Sin usar librerias de terceros
	java.net.HttpURLConnection
		Libreria mas antigua de java para hacer peticiones get
		Desventaja
			Es unn poco mas complejo de implementar
		Ventaja
			Funciona con versiones viejas de java
	apache
		Implementacion mas facil para versiones viejas de java
	spring
		RestTemplate 
			Se va a dejar de usar en futuras versiones
			Es un cliente con bloqueo
				Utiliza un hilo por cada cliente
		WebClient
			Permite llamadas sincronas y asincronas
			Es un cliente sin bloqueo
				Utiliza una arquitectura basada en eventos
				Pone en cola las "tareas" y utilzia menos hilos
			



#Pagina para hacer pruebas
	https://httpbin.org/

referencias
https://www.baeldung.com/java-http-request
https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
https://www.baeldung.com/spring-webclient-resttemplate
https://www.baeldung.com/rest-template
https://www.baeldung.com/spring-5-webclient
https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#spring-webflux