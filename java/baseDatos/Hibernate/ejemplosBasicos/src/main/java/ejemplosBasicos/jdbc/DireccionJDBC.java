package ejemplosBasicos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ejemplosBasicos.model.Direccion;

public class DireccionJDBC {
	private static final String INSERT_DIRECCION="insert into direccion (calle,ciudad,numero) values (?,?,?)";
	
	
	public static boolean insert(Direccion direccion) {
		Connection conexion=null;
		PreparedStatement ps=null;
		int filasModificadas=0;
		try {
			conexion=ConexionJDBC.obtenerConexionDB();
			ps=conexion.prepareStatement(INSERT_DIRECCION);
			ps.setString(1, direccion.getCalle());
			ps.setString(2, direccion.getCiudad());
			ps.setInt(3, direccion.getNumero());

			filasModificadas=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConexionJDBC.close(conexion,ps);
		}
		return filasModificadas==1;
	}

	
}
