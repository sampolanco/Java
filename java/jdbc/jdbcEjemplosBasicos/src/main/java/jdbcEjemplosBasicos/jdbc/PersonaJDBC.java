package jdbcEjemplosBasicos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcEjemplosBasicos.model.Persona;

public class PersonaJDBC {
	private static final String SELECT_ALL_PERSONAS="select id,nombre,apellido,edad from persona";
	private static final String INSERT_PERSONA="insert into persona (nombre,apellido,edad) values (?,?,?)";
	private static final String UPDATE_PERSONA="update persona set nombre=?,apellido=?,edad=? where id=?";
	//private static final String DELETE_PERSONA="delete form persona where id=?";
	
	
	public static boolean insert(Persona persona) {
		Connection conexion=null;
		PreparedStatement ps=null;
		int filasModificadas=0;
		try {
			conexion=ConexionJDBC.obtenerConexionDB();
			ps=conexion.prepareStatement(INSERT_PERSONA);
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setInt(3, persona.getEdad());

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
	public static List<Persona> findAll(){
		List<Persona> lista=new ArrayList<Persona>();
		Connection conexion=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conexion=ConexionJDBC.obtenerConexionDB();
			ps=conexion.prepareStatement(SELECT_ALL_PERSONAS);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellido");
				int edad=rs.getInt("edad");
				Persona persona=new Persona(nombre,apellido,edad);
				persona.setId(id);
				lista.add(persona);
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			ConexionJDBC.close(conexion,ps,rs);
		}
		return lista;
	}

	public static void insertDeletePersonaTransaccion(Persona persona,boolean generarError) {
		Connection conexion=null;
		PreparedStatement ps=null;
		PreparedStatement psUpdate=null;
		try {
			conexion=ConexionJDBC.obtenerConexionDB();
			conexion.setAutoCommit(false);
			
			ps=conexion.prepareStatement(INSERT_PERSONA);
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setInt(3, persona.getEdad());

			ps.executeUpdate();
			
			List<Persona> lista=PersonaJDBC.findAll();
			Persona personaModificar=null;
			if(lista.size()>1) {
				personaModificar=lista.get(lista.size()-1);
				psUpdate=conexion.prepareStatement(UPDATE_PERSONA);
				psUpdate.setString(1, "Nombre modificado");
				psUpdate.setString(2, "Apellido Modificado");
				psUpdate.setInt(3, 30);
				psUpdate.setInt(4, personaModificar.getId());
				psUpdate.executeUpdate();
			}
			if(generarError) {
				throw new RuntimeException("Rollback manual");
			}
			
			conexion.commit();
		}
		catch(Exception e) {
			try {
				System.out.println("Se hace rollback de transaccion");
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			ConexionJDBC.close(psUpdate);
			ConexionJDBC.close(conexion,ps);
		}
	}
	
}
