package ejemplos.basic;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainExcepciones {
	public void read() throws Throwable {}
	
    private static void m1() throws Exception { //Line 6
        System.out.println("NOT THROWING ANY EXCEPTION"); //Line 7
    }
    
	private static void metodoTiraIoException ()throws IOException,Exception{
		try {
			
		}
		catch(Exception e) {
			Exception ex = new Exception(e);
            throw ex;
		}
		throw new FileNotFoundException();
	}

	public static void main(String[] args) {

		try {
			metodoTiraIoException();
		}
		catch(FileNotFoundException e){
			
		}
		catch(Exception e){

		}
	}

}
