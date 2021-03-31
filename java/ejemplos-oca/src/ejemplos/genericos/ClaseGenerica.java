package ejemplos.genericos;

import java.util.List;

public class ClaseGenerica <T>{
	T valorGenerico;
	public <T> T metodoGenerico(List<T> parametroGenerico){
		return parametroGenerico.get(0);
	}
	
	public T metodoGenerico2(){
		return valorGenerico;
	}
	public String metodoGenerico3(){
		return valorGenerico.toString();
	}
	
	public String metodoGenericoSobrecargado(){
		return "hola";
	}
	public String metodoGenericoSobrecargado(List<String> atributos){
		return "hola";
	}
	//Misma firma que el metodo de arriba
	//public String metodoGenericoSobrecargado(List<Integer> atributos){
	//	return "hola";
	//}
}
