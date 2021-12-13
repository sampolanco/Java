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
		
	-Singleton
		-Una clase envuelve una simple clase 
		-La clase envoltorio es responsable de crear un objeto unico
		-La clase envoltorio provee la forma de acceder al objeto unico
		
Builder

		-Se utiliza par aconstruir objetos complejos que tienen muchas combinaciones
			-Si no se utilizara este patron 
				-tendriamos muchas subclases por cada tipo de objeto
				-otra solucion es un constructor gigante con todos los parametros (muchas banderas, muchos nulos)
		-Se construye usando objetos simples con una serie de pasos
		-Se separa la construccion a otro objeto "builder" 
		-Si se quire una diferente implementacion de como se construye un objeto se recomienda utilizar varios builders
			(Ejemplo: Una casa hecha totalmente de madera o de piedra)
		-https://refactoring.guru/design-patterns/builder
		
		
		

		
		
		