#JavaEE es un conjunto de apis como JTA, JPA, JMS, JAXws, JAXRS, JAS, JNDI etc

#Desde el 2018 JavaEE se convirtio en JakartaEE, pasando de Java EE 8 a Jakarta EE 8.
#La version 2021 de Jakarta es Jakarta EE 9
#Para correr Jakarta necesitamos descargar glasfish

#Documentacion
https://jakarta.ee/resources/#documentation
#Ejemplos
https://github.com/eclipse-ee4j/jakartaee-firstcup-examples
https://github.com/eclipse-ee4j/jakartaee-tutorial-examples

#Requisitos
Glasfish 5 admin-password
http://localhost:4848/
asadmin start-domain
asadmin stop-domain

69401

crear proyecto
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-j2ee-simple -DarchetypeVersion=1.4


#EJB
Som clases puras de java, los cuales al ser despleados en un servidor de aplicaciones java que soporte JavaEE agrega multiples caracteristicas
El codigo del EJB puede ser invocado por el cliente mediante una llamada local o remota mediante RMI



@Local
	No pueden ser llamados desde otra JVM
@Remote
	Pueden ser llamados desde otra JVM
@Stateless	
	Se utiliza en las implementaciones para definir el alcance del ejb


javax.ws vs javax.servlet