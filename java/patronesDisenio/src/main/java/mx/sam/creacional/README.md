Los patrones creacionales
	-Proveen una manera de crear objetos mientras se esconde la logica de la creacion
	-Evitan usar el operador new
	-Proveen mas flexibilidad en decidir que objetos necesitan ser creados para un caso de uso
	
	
Factory

	-Factory comun
		-Se crea un objeto sin exponer la logica de la creacion.
		-Se hace referencia al objeto creado mediante una interface
	-Abstract Factory
		-Es un Factory de Factories 
		-Una interface es responsable de crear un factory de objetos relacionadosa
	-Desventajas
		-Se crea complejidad en el código ya que se requiere la creacion de multiples clases
		
Singleton

	-Se usa para tener solo una instancia de una clase
	-Una clase envuelve una simple clase 
	-La clase envoltorio es responsable de crear un objeto unico
	-La clase envoltorio provee la forma de acceder al objeto unico
	-Desventajas
		-Viola el principio de una sola responsabilidad
		-Se requiere de un trato especial cuando se trata de multiples hilos
		-Si se requiere hacer un unit test se tienen dificiltades ya que el constructor es privado
		
Builder

	-Se utiliza par aconstruir objetos complejos que tienen muchas combinaciones
	-Se construye usando objetos simples con una serie de pasos
	-Se separa la construccion a otro objeto "builder" 
	-Si se quire una diferente implementacion de como se construye un objeto se recomienda utilizar varios builders
		(Ejemplo: Una casa hecha totalmente de madera o de piedra)
	-https://refactoring.guru/design-patterns/builder
	-Si no se utilizara este patron 
		-tendriamos muchas subclases por cada tipo de objeto
		-otra solucion es un constructor gigante con todos los parametros (muchas banderas, muchos nulos)
	-Desventajas
		-Se crea complejidad en el código ya que se requiere la creacion de multiples clases
		
Prototype
	
	-Se usa cuando se necesita que el código no dependa de una clase en concreto
	-Consiste en realizar copias existente de objetos sin hacer el codigo dependiente de las clases
	-Se tiene acceso a todas las variables, ya sean privadas o protected
	-Si no se utilizara este patron
		-Se tendria que crear un nuevo objeto y recorrer el viejo copiando campo por campo 	
			-no todos los objetos son visibles
			-como se tiene que conocer el objeto a copiar, el código se vuelve dependiente
	-Desventajas
		-Si se tienen referencias circulares puede ser un problema
			
		
		
		