package ejemplos.lambda.stream;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import ejemplos.lambda.Persona;

public class Main {

	public void forEach(List<Persona> lista) {
		lista.forEach(elemento->out.print(elemento.getNombre()+","));
	}
	public void filtrar(List<Persona> lista) {
		lista
			.stream()
			.filter(elemento ->elemento.getApellido().startsWith("Pola"))
			.forEach(elemento -> out.print("_"+elemento.getNombre()));
			//forEach(out::println);
	}
	public void sort(List<Persona> lista) {
		lista
			.stream()
			.sorted((x,y)->{
				return x.getNombre().compareTo(y.getNombre());
			})
			.forEach(elemento -> out.print("_"+elemento.getNombre()));
	}
	/*
	 * El map transforma el stream y regresa otro stream de cualquier tipo especificado
	 * */
	public void map(List<Persona> lista) {
		lista
			.stream()
			.map(elemento->{
				return elemento.getNombre();
			})
			.forEach(nombre -> out.print("_"+nombre));
	}
	public void limitar(List<Persona> lista) {
		lista
			.stream()
			.limit(2)
			.forEach(elemento -> out.print("_"+elemento.getNombre()));
	}
	public void contar(List<Persona> lista) {
		long conteo=lista
			.stream()
			.count();
		out.print(conteo);
	}
	
	public static void main(String[] args) {
		Main clase=new Main();
		List<Persona> lista =new ArrayList<>();
		lista.add(new Persona("Samuel","Polanco"));
		//lista.add(null);
		lista.add(new Persona("Naomi","Polanco"));
		lista.add(new Persona("Amadeus","Polanco"));
		lista.add(new Persona("Samuel Antonio","Polanco"));
		lista.add(new Persona("Aurora","Rodriguez"));
		out.println("ForEach");
		clase.forEach(lista);
		out.println("\nFiltrar");
		clase.filtrar(lista);
		out.println("\nSort");
		clase.sort(lista);
		out.println("\nMap");
		clase.map(lista);
		out.println("\nLimitar");
		clase.limitar(lista);
		out.println("\nContar");
		clase.contar(lista);
	}
}
