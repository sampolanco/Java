Los patrones estructurales
	-Se refiere a la composicion de clases y objetos.
	-Se usa la herencia para componer interfaces
	-Define maneras de componer objetos para obtener nuevas funcionalidades
	
	
Adapter
	
	-Sirve como puente entre dos interfaces incompatibles
	-Sirve como una especie de traductor entre nuestro codigo y clases de terceros
	-Desventajas
		Agrega complejidad al intruducir un set de nuevas interfaces y clases
		Aveces es mas simple cambiar la clase de servicio para que haga match con el resto del código
		
Bridge

	-Permite dividir una clase grande en un set de clases relacionadas
	-Evita que se creen muchas clases cuando se utiliza herencia con multiples combinaciones
	-Cambia herencia por composicion
	-Ventajas
		Se puede cambiar la implementacion en tiempo de ejecucion
		
Composite 
	
	-Consiste en tener en un objeto una lista de objetos del mismo tipo
	-Se deben tener metodos para acceder, agregar o remover elementos de la lista
	
Decorator

	-Este patron agrega nuevo comportamiento a los objetos
	-Se envuelve el objeto en otro que le agrega funcionalidad
	-El objeto que envuelve implementa la misma interface que el objeto al que envuelve
	-Desventajas
		Es dificil implementar un decorador en el cual el orden de los decoradores no importe
	
Facade
	
	-Es una fachada que solo expone los componentes que se usarán
	-Esconde toda la funcionalidad compleja que se tiene por detras de la fachada