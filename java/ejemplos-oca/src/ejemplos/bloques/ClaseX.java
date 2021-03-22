package ejemplos.bloques;

public class ClaseX {
	static {
		int variableBloque=12;
		System.out.println("metodo de bloque estatico ClaseX");
	}
	{
		System.out.println("metodo de bloque ClaseX");
	}
	protected ClaseX(){
		System.out.println("metodo de constructor ClaseX");
	}
}
