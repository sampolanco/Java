Los patrones de comportamiento
	-Se refiere a la cominicacion entre objetos
	
Chain of responsibility
	
	-Es un patron que permite pasar solicitudes a lo largo de una cadena de manejadores
		-cada manejador decide si procesa o pasa al siguiente manejador
	-Todos los manejadores tienen la oportunidad de procesar la solicitud
	
Command

	-Una solicitud se envuelve en un objeto
	-Se usa comunmente en las GUI
	-Funciona como capa intermedia entre la GUI y la logica del negocio
		-Asi reduce el acoplamiento
		
Iterator

	-Se utiliza para recorrer elementos de una colección sin exponer su representación (lista, pila, árbol, etc.)
	-Recorrer una lista es facil, pero objetos complejos como arboles no
	-Se extrae el comportamiento del recorrido de una coleccion y se coloca en un objeto llamado iterador
		-se tienen valores como posicion actual, y elementos restantes
		-varios iteradores pueden recorrer la lista al mismo tiempo
	-desventajas
		-usar este patron puede ser excesivo si solo se necesitan colecciones sencillas
		-puede ser menos eficiente que recorrer directamente los elementos de algunas colecciones
		
Mediator *revisar
	
	-Permite reducir las dependencias caoticas entre objetos
	-Restringe las comunicaciones directas entre objetos
	-Se colabora mediante un objeto mediador
	-desventajas
		-con el tiempo un mediador puede convertirse en un objeto todo poderoso (antipatron)
	-como implementar
		-identificar las clases fuertemente acopladas
		-Los componentes deben almacenar una referencia al objeto mediador (generalmente mediante el constructor)
		-Cambia el código de los componentes de forma que invoquen el método de notificación del mediador en lugar de los métodos de otros componentes
		
Memento
	
	-Permite guardar y restaurar el estado previo de un objeto sin revelar los detalles de la implementacion
	-la propia clase editora puede hacer la instantánea
		-se evita tener datos publicos
	-la clase que guarda el estado se le llama memento
	-una clase cuidadora es la que almacena una pila de mementos
	-desventajas
		-puede consumir mucha ram si se crean muchos mementos
				
Observer
	
	-Tambien es llamado Listener o Subscriber
	-define un mecanismo para notificar a varios objetos sobre cualquier evento que suceda a un objeto
	-la diferencia entre Mediator y Observer a menudo resulta difusa
	-desventajas
		-el orden en el que se notifica a los clientes es aleatorio
		
		