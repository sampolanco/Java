package ejemplos.lambda.stream;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import model.escuela.Alumno;

public class MainStream {

	public void forEach(List<Alumno> lista) {
		lista.forEach(elemento->out.print(elemento.getNombre()+","));
	}
	public void filtrar(List<Alumno> lista) {
		lista
			.stream()
			.filter(elemento ->elemento.getNombre().startsWith("Pola"))
			.forEach(elemento -> out.print("_"+elemento.getNombre()));
			//forEach(out::println);
	}
	public void sort(List<Alumno> lista) {
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
	public void map(List<Alumno> lista) {
		lista
			.stream()
			.map(elemento->{
				return elemento.getNombre();
			})
			.forEach(nombre -> out.print("_"+nombre));
	}
	public void limitar(List<Alumno> lista) {
		lista
			.stream()
			.limit(2)
			.forEach(elemento -> out.print("_"+elemento.getNombre()));
	}
	public void contar(List<Alumno> lista) {
		long conteo=lista
			.stream()
			.count();
		out.print(conteo);
	}
	
	public static void main(String[] args) {
		MainStream clase=new MainStream();
		List<Alumno> lista =new ArrayList<>();
		lista.add(new Alumno());
		//lista.add(null);
		lista.add(new Alumno());
		lista.add(new Alumno());
		lista.add(new Alumno());
		lista.add(new Alumno());
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
