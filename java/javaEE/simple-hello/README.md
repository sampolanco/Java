Esta aplicacion contiene elementos de javax.servlet y javax.ws.rs

Servlet
Uris
 -http://localhost:8080/simple-hello/Servlet?nombre=sam
Datos
 Dentro de la carpeta servlet se definen los metodos doget y dopost
 

JavaxRS
Se configuta con la clase ApplicationConfig, extendiento Application y con la anotacion @ApplicationPath
Uris
 -http://localhost:8080/simple-hello/rest
 -http://localhost:8080/simple-hello/rest/persona
Documentacion
 -https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/deployment.html
 
 
Beans

Configuracion
 -En el archivo beans.xml se define bean-discovery-mode="all"