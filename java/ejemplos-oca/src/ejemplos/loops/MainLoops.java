package ejemplos.loops;

public class MainLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y,z=10;
		x=y=z;
		System.out.println(""+x+"_"+y+"_"+z);
		
		foorLoop();
		
	}
	private static void foorLoop() {
		for(int x=20,y=30,z=10;(x+y+z>50)==true && (x+y+z<70);x++,y++,z=getValorZ(),System.out.println("imprimiendo")) {
			System.out.println(""+x+"_"+y+"_"+z);
		}
		int [] cadenaInt=new int[]{1,2,3,4};
		Integer cadanaInteger[]=new Integer[]{1,2,3,4};
		for(int i :cadenaInt) {
			System.out.println(i);
		}
		for(int i :cadanaInteger) {
			System.out.println(i);
		}
		FORINTEGER: for(int i :cadanaInteger) {
			FORINT: for(int j :cadenaInt) {
				if(j==3) 
					continue FORINT;
				if(i==3) 
					break FORINTEGER;
				System.out.println("nested: "+i+j);
			}		
		}
	}
	private static int getValorZ(){
		return 5;
	}
	private static void whileLoop() {
		while(true)
			System.out.println("loop");
	}
}
