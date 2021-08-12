package com.demo;

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
		String crearTablaScript=
				"CREATE TABLE IF NOT EXISTS persona (\r\n" + 
				"  id INT AUTO_INCREMENT  PRIMARY KEY,\r\n" + 
				"  nombre VARCHAR(250) NOT NULL,\r\n" + 
				"  apellido VARCHAR(250) NOT NULL,\r\n" + 
				"  edad INT\r\n" + 
				");";
    	Connection conn = DriverManager.getConnection("jdbc:h2:~/test","","");
    	Statement stm=conn.createStatement();
    	stm.executeUpdate(crearTablaScript);
    	conn.close();
    	System.out.println("Tabla de persona procesada");
    }
}
