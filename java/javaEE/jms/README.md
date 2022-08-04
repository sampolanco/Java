
RPC y RMI son sincronos, por lo que se requiere que el cliente y el servidor estén disponibles al mismo tiempo
	Los sistemas Message-Oriented Middleware (MOM) se basan en un modelo asincrono
		provee una abstraccion de una cola de mensajes que puede ser accesada en una red 
JMS se diseño como una solucion empresarial facil para enviar y recibir de forma asincrona datos y eventos
	Es una API que soporta point-to-point (queuing) y publish-subscribe.

USO
	Se necesita cualquier servidor de aplicaciones
		se puede crear un QueueConnectionFactory o un TopicConnectionFactory
	Se necesita
		Un servidor corriendo
		Un cliente productor
		Un cliente consumidor


Referencia
	https://www.oracle.com/technical-resources/articles/java/intro-java-message-service.html