#Poi
	#Documentacion https://poi.apache.org/components/spreadsheet
	#Ejemplos http://poi.apache.org/components/spreadsheet/how-to.html
	
	#HSSF
		paquete que contiene las implementaciones para versiones antiguas de documentos (97)
	
	#XSSF
		paquete que contiene las implementaciones para nuevas versiones de documentos (2017)
	
	#HSSF y XSSF
		proveen formas para leer, escribir y modificar hojas de calculo
			*estructuras de bajo nivel para propositos especiales
			*eventmodel para un modo eficiente de solo lectura
			*usermodel para abrir en modo lectura y escritura
	
	#eventmodel
		Si solo se quiere leer
		facil para manejar celdas y filas
		paquetes: org.apache.poi.hssf.eventusermodel package
					 org.apache.poi.xssf.eventusermodel
					 
	#usermodel
		Si se quiere leer y escribir (Tiene un uso de memoria mas intensivo)
		Se requiere el uso de SAX cuando se usa con XSSF
		paquetes: org.apache.poi.hssf.eventusermodel package
					 org.apache.poi.xssf.eventusermodel
	
	#SXSSF 
		es una extension de XSSF para streaming para no exceder la memoria del heap al querer escribir en el archivo excel
		
		
#Excel Streaming Reader
	#Una de las desventajas al usar SXSSF es que se tiene que usar parsers con SAX lo que no nos permite acceder a las propiedades de row y cell
		*Esta libreria es un wrapper de SXSSF para poder usar esas propiedades
					 
					 
					 
					 
					 
					 
					 
					 