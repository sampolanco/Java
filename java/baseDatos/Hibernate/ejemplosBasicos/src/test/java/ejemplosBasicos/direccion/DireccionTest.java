package ejemplosBasicos.direccion;

import org.junit.Test;

import ejemplosBasicos.jdbc.DireccionJDBC;
import ejemplosBasicos.model.Direccion;

public class DireccionTest {

	@Test
	public void insertDireccion() {
		Direccion direccion=new Direccion("Maza","acueducto",21);
		DireccionJDBC.insert(direccion);
	}

}
