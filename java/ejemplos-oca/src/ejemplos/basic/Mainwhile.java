package ejemplos.basic;

public class Mainwhile {

	public static void loopInfinito() {
        while (true) {
            System.out.println("sa");
        }
	}
	public static void main(String[] args) {
        final boolean flag;
        flag = true;
        //En ese caso no lanza error de compilacion anqune se sepa que la variable es final y el loop es infinito
        while(flag) {
            System.out.println("Good Morning!");
        }
        
        int i;
        outer: 
        do {
            i = 5;
            inner:
            while (true) {
                System.out.println(i--);
                if (i == 4) {
                    break outer;
                }
            }
        } while (true);
        System.out.println("fin");

	}

}
