package ejemplos.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.escuela.Alumno;
import model.escuela.Escuela;

public class MainColecciones {
	
	public static void main(String... arg) {
		//crearArrayList();
		//procesarClonadoAlumno();
		eliminarCollection();
		
	}
	public static void eliminarCollection() {
		Collection<String> coleccionArrayList = new ArrayList<>();
		coleccionArrayList.add(new String("sam"));
		coleccionArrayList.add(new String("sam"));
		coleccionArrayList.remove("sam");

		System.out.println(coleccionArrayList);
		
        Boolean [] arr = new Boolean[2];
        List<Boolean> list = new ArrayList<>();
        list.add(arr[0]);
        list.add(arr[1]);

        /*if(list.remove(0)) {//nullpointer
            list.remove(1);
        }*/
        System.out.println(list);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(new Integer(2));
        list2.add(new Integer(1));
        list2.add(new Integer(0));

        list2.remove(list2.indexOf(0));

        System.out.println(list2);
        
        //------
        List<Integer> list3= new ArrayList<>();
        list3.add(100);
        list3.add(200);
        list3.add(100);
        list3.add(200);
        //list3.remove(100); excepcion
        list3.addAll(1, list2);
        
        System.out.println(list3);

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
	public static void procesarClonadoInteger() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		Integer valor=arrayList.get(0);
		arrayList.remove(new Integer(10));
		valor++;
		System.out.println(arrayList.get(0));
		
		ArrayList<Integer> arrayList2=(ArrayList<Integer>) arrayList.clone();
		valor=arrayList2.get(0);
		valor++;
		System.out.println(arrayList.get(0));
	}
	public static List<Alumno> procesarClonadoAlumno() {
		ArrayList<Alumno> arrayList = new ArrayList<>();
		Alumno alumno1=new Alumno();
		alumno1.setNombre("sam");
		arrayList.add(alumno1);
		Alumno valor=arrayList.get(0);
		valor.setNombre("pola");
		System.out.println(arrayList.get(0).getNombre());
		
		ArrayList<Alumno> arrayList2=(ArrayList<Alumno>) arrayList.clone();
		valor=arrayList2.get(0);
		valor.setNombre("rod");
		System.out.println(arrayList.get(0).getNombre());
		return null;
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
