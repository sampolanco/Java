package ejemplos.basic;

public class CicloFor {
	/*
	 * Probar ciclo for
	 * */
	private static void cicloForMedodo() {
		int x=0;
		cicloFor1:
		for(;x<2;) {
			x++;
			System.out.print(x+"-");
			if(x==4)
				break cicloFor1;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cicloForMedodo();
	}

}
