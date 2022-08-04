package mx.sam.comportamiento.iterator.tienda;

import mx.sam.comportamiento.iterator.tienda.model.CatalogoDepartamento;
import mx.sam.comportamiento.iterator.tienda.clasesiterator.*;;

public class Main {

	public static void main(String[] args) {
		CatalogoDepartamento departamentos = new CatalogoDepartamento();

	      for(MiIterator iter = departamentos.getIterator(); iter.hasNext();){
	         String name = (String)iter.next();
	         System.out.println("Departamento : " + name);
	      } 	
	}

}
