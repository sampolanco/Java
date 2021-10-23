Strut2

#Requisitos
	Servlet API 2.4 o mas
	JSP 2.0 o mas
	Java 7 o mas

#Configuracion
	Para habilitar a Struts trabajar con la aplicacion web se necesita agregar un filter mapping al web.xml 
	Se tiene que agregar el archivo de configuracion basida struts.xml dentro de src/main/resources
		se puede omitir si se usan convenciones o anotaciones
		esto sirve para especificar la relacion entre una URL, un Java class, y una view page

#Taglibs
	Se agrega el tag <%@taglib prefix="s" uri="/struts-tags"%>

#Documentacion
	https://struts.apache.org/getting-started/how-to-create-a-struts2-web-application.html

#Ejecutar
	mvn jetty:run