package ejemplos.basic;

import java.util.ArrayList;
import java.util.List;

public class MainBoolean {

	public static void main(String... args) {
        boolean flag = false;
        System.out.println((flag = true) | (flag = false) || (flag = true));
        System.out.println(flag);
	}
}
