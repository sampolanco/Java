package ejemplos.lambda.stream;

import static java.lang.System.out;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ejemplos.lambda.Persona;

public class MainParalelo {

	private void pintarParalelo(List<Integer> lista) {

	}

	private String pintar(List<Integer> lista) {
		LocalDateTime inicio=LocalDateTime.now();
		
		//for(Integer i :lista)
			//out.println(i);
		lista.forEach(elemento->out.println(elemento*2));
		
		LocalDateTime fin=LocalDateTime.now();
		LocalDateTime tiempo= fin
				.minusSeconds(inicio.getSecond())
				.minusNanos(inicio.getNano());
		return tiempo.getSecond() +" Segundos_"+ tiempo.getNano() + "Nanos";
	}
	private String pintarStream(List<Integer> lista) {
		LocalDateTime inicio=LocalDateTime.now();
		
		lista.stream().forEach(elemento->out.println(elemento));
		
		LocalDateTime fin=LocalDateTime.now();
		LocalDateTime tiempo= fin
				.minusSeconds(inicio.getSecond())
				.minusNanos(inicio.getNano());
		return tiempo.getSecond() +" Segundos_"+ tiempo.getNano() + "Nanos";
	}
	private String pintarStreamParalelo(List<Integer> lista) {
		LocalDateTime inicio=LocalDateTime.now();
		
		lista.parallelStream().forEach(elemento->out.println(elemento));
		
		LocalDateTime fin=LocalDateTime.now();
		LocalDateTime tiempo= fin
				.minusSeconds(inicio.getSecond())
				.minusNanos(inicio.getNano());
		return tiempo.getSecond() +" Segundos_"+ tiempo.getNano() + "Nanos";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainParalelo clase=new MainParalelo();
		List<Integer> lista =new ArrayList<>();
		for(int i=0;i<100000;i++)
			lista.add(i);
		String tiempo1=clase.pintar(lista);
		String tiempo2=clase.pintarStream(lista);
		String tiempo3=clase.pintarStreamParalelo(lista);
		out.println("pintar: "+ tiempo1);
		out.println("pintarStream: "+ tiempo2);
		out.println("pintarStreamParalelo: "+ tiempo3);
	}


}
