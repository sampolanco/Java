package ejemplos.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.escuela.Escuela;

public class MainColecciones {
	public static void main(String... arg) {
		crearArrayList();
	}
	public static Collection<Integer> procesarCollection() {
		Collection<Integer> coleccionArrayList = new ArrayList<>();
		coleccionArrayList.add(1);
		coleccionArrayList.add(2);
		//coleccionArrayList.listIterator(); <- no lo tiene
		Object[] lista=coleccionArrayList.toArray();
		coleccionArrayList.isEmpty();
		return coleccionArrayList;
	}
	public static ArrayList<Integer> procesarArrayList() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.listIterator();
		Object[] lista=arrayList.toArray();
		arrayList.isEmpty();
		return arrayList;
	}
	public static void pintarArrayListIsEmpty(ArrayList<Integer> lista) {
		//pintarArrayListIsEmpty(null); Excepcion
		System.out.println("isEmpty: "+new ArrayList<>().isEmpty());
	}
	
	public static void crearArrayList() {
		Escuela escuela1=new Escuela();
		Escuela escuela2=new Escuela();
		escuela1.setNombre("Escuela1");
		escuela2.setNombre("Escuela2");

		ArrayList<Escuela> arrayList = new ArrayList<>();
		arrayList.add(escuela1);
		
		ArrayList<Escuela> arrayList2=new ArrayList<>(arrayList);
		arrayList2.set(0, escuela2);
				
		System.out.println(arrayList.get(0).getNombre());
		System.out.println(arrayList2.get(0).getNombre());
		
		ArrayList<Escuela> arrayList4=arrayList;
		arrayList2.set(0, escuela2);

		System.out.println(arrayList.get(0).getNombre());
		System.out.println(arrayList2.get(0).getNombre());
		
		escuela1.setNombre("Escuela1 cambiada");
		
		System.out.println(arrayList.get(0).getNombre());
		System.out.println(arrayList2.get(0).getNombre());
	}
}
