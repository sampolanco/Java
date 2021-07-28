package javaEjemplos.archivos;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainOutputStream {

	public static void main(String[] args) throws IOException {
        String ubicacion="\\WbasketSEDOFEM\\tmp\\edofin\\2020\\11\\26\\78\\formatos\\FormatoSistemaAlertas_78_2011261356.xlsx";
        FileOutputStream out = null;
        InputStream in = null;
        
        in = new BufferedInputStream(new FileInputStream(ubicacion));
        out = new FileOutputStream("C:\\Users\\samy_\\Desktop\\formato.xlsx");
        int count;
        byte buf[] = new byte[5120];
        while ((count = in.read(buf)) > -1) {
        	out.write(buf, 0, count);
        }
	}

}
