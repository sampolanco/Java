package ejemplosBasicos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.Test;

public class crearBaseDatosTest {

	@Test
	public void test() throws Exception {
    	Connection conn = DriverManager.getConnection("jdbc:h2:~/test","","");
    	conn.close();
    	System.out.println("Conexion a h2 exitosa");
    	JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:~/test", "", "");
    	Connection conn2 = cp.getConnection();
    	conn2.close(); 
    	cp.dispose();    	
    	System.out.println("Conexion a pool h2 exitosa");
	}
	@Test
	public void crearTablaPersona() throws Exception {
		String crearTablaPersona=
				"CREATE TABLE persona (" + 
				"  id INT AUTO_INCREMENT  PRIMARY KEY," + 
				"  nombre VARCHAR(250) NOT NULL," + 
				"  apellido VARCHAR(250) NOT NULL," + 
				"  edad INT,"+
				"  id_direccion INT," +
				"  FOREIGN KEY (id_direccion) REFERENCES direccion(id)"+
				");";
		String crearTablaDireccion=
				"CREATE TABLE direccion (" + 
				"  id INT AUTO_INCREMENT  PRIMARY KEY," + 
				"  ciudad VARCHAR(250) NOT NULL," + 
				"  calle VARCHAR(250) NOT NULL," + 
				"  numero INT" + 
				");";
    	Connection conn = DriverManager.getConnection("jdbc:h2:~/test","","");
    	Statement stm=conn.createStatement();
    	stm.executeUpdate("DROP TABLE direccion CASCADE");
    	stm.executeUpdate("DROP TABLE persona CASCADE");
    	stm.executeUpdate(crearTablaDireccion);
    	System.out.println("Tabla de direccion procesada");
    	stm.executeUpdate(crearTablaPersona);
    	System.out.println("Tabla de persona procesada");
    	
    	stm.close();
    	conn.close();
    }
	

}
