package ejemplos.lambda.colecciones;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import model.escuela.Alumno;

public class MainColecciones {

	public void forEach(List<Alumno> lista) {
		lista.forEach(elemento->out.print(elemento.getNombre()+","));
	}
	public void removeIf(List<Alumno> lista) {
		lista.removeIf(elemento->{
			return elemento.getNombre().equals("Samuel");
		});	

		forEach(lista);
	}
	public void sort(List<Alumno> lista) {
		lista.sort((x,y)->{
			return x.getNombre().compareTo(y.getNombre());
		});	

		forEach(lista);
	}
	public static void main(String[] args) {
		MainColecciones clase=new MainColecciones();
		List<Alumno> lista =new ArrayList<>();
		lista.add(new Alumno());
		lista.add(new Alumno());
		lista.add(new Alumno());
		out.println("ForEach");
		clase.forEach(lista);
		out.println("\nRemoveIf");
		clase.removeIf(lista);
		out.println("\nSort");
		clase.sort(lista);
	}
}
