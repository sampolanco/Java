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
			
State
	
	-Permite a un objeto alterar su comportamiento cuando un estado interno cambia
	-Está relacionado con el concepto de maquina de estados finitos
		-El programa se comporta diferente dependiendo el estado
	-Se crean nuevas clases para todos los estados posibles de un objeto 
	-Para la transición entre estados
		-se sustituye el objeto de un estado por el del nuevo estado
		-todas las clases de estado siguen la misma interfaz
	-Esta estructura puede resultar similar al patrón Strategy
		-en el patrón State, los estados particulares pueden conocerse entre sí
	-desventajas
		-puede ser excesivo si la maquina de estados tiene pocos estados o estos cambian raramente
		
Strategy 
	
	-Permite hacer que las implementaciones de algun algoritmo sean intercambiables
	-La clase original (contexto) almacena una referencia a una de las estrategias
	-El cliente seleccioa que estrategia pasarle al contexto
	-desventajas
		-si solo se tienen un par de algoritmos que raramente cambian no hay razon real para complicar el programa
		-se dene conocer las diferencias entre cada estrategia para seleccionar la adecuada
		
Template

	-Define el esqueleto (pasos a seguir) de un algoritmo en una superclase
		- permite que las subclases sobreescriban el algoritmo sin cabiar la estructura
	-Factory es una especialización del Template
	-desventajas
		-el esqueleto puede limitar la creacion
		-dificil de mantener si se tienen muchos pasos
		
Visitor

	-permite separar algoritmos de los objetos sobre los que operan
	-se crea una clase visitante 
		-se le pasa el objeto a visitar
	-se utiliza para visitar todos los elementos de una estructura compleja como un arbol
	-desventajas
		-se tiene que actualizar a todos los visitantes cada vez que una clase se añada o elimine
		-los visitantes pueden carecer de acceso a los campos y metodos para visitar
		
		