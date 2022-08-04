package aplicacionClienteConsumidor;

import javax.jms.*;
import javax.naming.InitialContext;

public class MyReceiver {
	public static void main(String[] args) {
		try {
			// 1) Create and start connection
			InitialContext ctx = new InitialContext();
			QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("myQueueConnectionFactory");
			QueueConnection con = f.createQueueConnection();
			con.start();
			// 2) create Queue session
			QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			// 3) get the Queue object
			Queue t = (Queue) ctx.lookup("myQueue");
			// 4)create QueueReceiver
			QueueReceiver receiver = ses.createReceiver(t);

			// 5) create listener object
			MyListener listener = new MyListener();

			// 6) register the listener object with receiver
			receiver.setMessageListener(listener);

			System.out.println("Listo para recibir mensajes...");
			System.out.println("Ctrl+c para parar...");
			while (true) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
