package ejemplos.bloques;

public class MainBloques {
	int valorIntClase=2;

	public static void main(String[] args) {
		System.out.println("inicio de main");

		ClaseX clasex=new ClaseX();
		{
			int variableBloque=12;
			int valorIntClase=21;
		}
		for(int i=0;i<10;i++) {
			int valorIntClase=55;
		}
		int variableBloque=12;

	}

}
