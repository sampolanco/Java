package ejemplos.basic;

import java.time.LocalDate;

public class MainInstanceOf {

	public static void main(String[] args) {

        Integer x=new Integer(10);
        boolean flag2 = x instanceof Object; 
        boolean flag3 = x instanceof Integer;
        //boolean flag4 = x instanceof Throwable; error de compilacion
        //boolean flag1 = x instanceof LocalDate;  error de compilacion

	}
}
