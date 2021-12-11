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
		
	-Builder
		-Se utiliza par aconstruir objetos complejos 
		-Se construye usando objetos simples con una serie de pasos
		-El objeto final se construye mediante un metodo build
		
		