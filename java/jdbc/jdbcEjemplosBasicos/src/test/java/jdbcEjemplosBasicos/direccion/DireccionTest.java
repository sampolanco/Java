package jdbcEjemplosBasicos.direccion;

import org.junit.Test;

import jdbcEjemplosBasicos.jdbc.DireccionJDBC;
import jdbcEjemplosBasicos.model.Direccion;

public class DireccionTest {

	@Test
	public void insertDireccion() {
		Direccion direccion=new Direccion("Maza","acueducto",21);
		DireccionJDBC.insert(direccion);
	}

}
