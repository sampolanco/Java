package jdbcEjemplosBasicos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionJDBC {
	private static final String JDBC_URL="jdbc:h2:~/test";
	private static final String JDBC_USUARIO="";
	private static final String JDBC_PASS="";
	
	public static Connection obtenerConexionDB() throws SQLException {
		Connection conn = DriverManager.getConnection(JDBC_URL,JDBC_USUARIO,JDBC_PASS);
    	return conn;
	}
	public static void close(Connection conexion) {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al cerrar la conexion");
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement ps) {
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al cerrar el preparedStatement");
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al cerrar el ResultSet");
			e.printStackTrace();
		}
	}
	public static void close(Connection conexion,PreparedStatement ps) {
		try {
			conexion.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al cerrar la conexion");
			e.printStackTrace();
		}
	}
	public static void close(Connection conexion,PreparedStatement ps,ResultSet rs) {
		try {
			conexion.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al cerrar la conexion");
			e.printStackTrace();
		}
	}
}
