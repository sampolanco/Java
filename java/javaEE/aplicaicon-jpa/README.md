Aplicacion con ejemplos de JPA utilizando una base de datos en memoria (H2) y hibernate

Notas
	-Se cambia de 
		Esto es debido a que el servidor de aplicaciones es el que se encargará de administrar las transacciones
		
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
		Se puede utilizar transaction-type="RESOURCE_LOCAL" o transaction-type="JTA"
			En RESOURCE_LOCAL se configuran los datos de conexion y se manejan transacciones localmente
			En JTA se configura el nombre de la conexion que se configura en el servidor de aplicaciones
			 -El servidor de aplicaciones se encarga de manejar las transacciones
			 -Para este caso se configuró la conexion en la consola de glassfish
			    se insertó el jar de h2 "h2.jar" en las librerias de glassFish "glassfish5\glassfish\lib"
			 -Al momento de utilizar @PersistenceContext(unitName="aplicacionjpaPU") se tiene que utilizar JTA
	-log4j2
		Por default se busca en WEB-INF
		 Debe estar en el classpath para ser tomado por el servidor. 
		 Todo lo que está en src/main/resources termina en la carpeta WEB-INF
	
	
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