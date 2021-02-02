package ejemplos.lambda.colecciones;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import ejemplos.lambda.Persona;

public class Main {

	public void forEach(List<Persona> lista) {
		lista.forEach(elemento->out.print(elemento.getNombre()+","));
	}
	public void removeIf(List<Persona> lista) {
		lista.removeIf(elemento->{
			return elemento.getNombre().equals("Samuel");
		});	

		forEach(lista);
	}
	public void sort(List<Persona> lista) {
		lista.sort((x,y)->{
			return x.getNombre().compareTo(y.getNombre());
		});	

		forEach(lista);
	}
	public static void main(String[] args) {
		Main clase=new Main();
		List<Persona> lista =new ArrayList<>();
		lista.add(new Persona("Samuel","Polanco"));
		lista.add(new Persona("Naomi","Polanco"));
		lista.add(new Persona("Amadeus","Polanco"));
		out.println("ForEach");
		clase.forEach(lista);
		out.println("\nRemoveIf");
		clase.removeIf(lista);
		out.println("\nSort");
		clase.sort(lista);
	}
}
