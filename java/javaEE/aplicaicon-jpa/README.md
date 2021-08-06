Aplicacion con ejemplos de JPA utilizando una base de datos en memoria (H2) y hibernate

Documentacion XMLs
	-https://jakarta.ee/xml/ns/jakartaee/
	
JPA es un estandar de persistencia en java.
	-en este proyecto se verá la implementacion on hibernate
	
La idea es trabajar con objetos java y no con sql
	-abstrayendo la comunicacion con la bd 
	-creando un estandar para la manipulacion de la bd
	
Configuracion
	-persistence.xml
		Este archivo se ubica en META-INF y aqui es donde se configuran aspectos de la conexion a la base de datos
		Los metadatos del archivo van ligados a los del web.xml.
			Se puede entrar a la liga que se tiene en el web.xml para ver la configuracion del persistence.xml
		 	 ejemplo:http://xmlns.jcp.org/xml/ns/javaee
	-log4j2
		Por default se busca en WEB-INF
		 Debe estar en el classpath para ser tomado por el servidor.
	
	
EJB
	los metodos de un ejb so transaccionales por default
	no es necesario persistir los objetos en los metodos. Al final se revisan los objetos editados y se persisten
	
H2
	instalacion
		https://www.h2database.com/html/cheatSheet.html
	documentacion
		https://www.h2database.com/html/main.html
	prueba
		http://localhost:8080/aplicacion-jpa/rest/testdb
		
	Que es un conection pool?