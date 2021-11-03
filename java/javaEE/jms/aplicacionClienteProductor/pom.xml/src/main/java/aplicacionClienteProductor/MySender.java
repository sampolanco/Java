package aplicacionClienteProductor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.*;
import javax.jms.*;
import com.sun.enterprise.naming.*;

public class MySender {

	public static void main(String[] args) {
		try { 
			InitialContext ctx = new InitialContext();
			QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("myQueueConnectionFactory");
			QueueConnection con = f.createQueueConnection();
			con.start();
			// 2) create queue session
			QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			// 3) get the Queue object
			Queue t = (Queue) ctx.lookup("myQueue");
			// 4)create QueueSender object
			QueueSender sender = ses.createSender(t);
			// 5) create TextMessage object
			TextMessage msg = ses.createTextMessage();

			// 6) write message
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("Escribe mensaje para enviar:");
				String s = b.readLine();
				if (s.equals("end"))
					break;
				msg.setText(s);
				// 7) send message
				sender.send(msg);
				System.out.println("Mensaje enviado");
			}
			// 8) connection close
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
