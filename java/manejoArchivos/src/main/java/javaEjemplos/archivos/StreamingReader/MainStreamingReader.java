package javaEjemplos.archivos.StreamingReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import com.monitorjbl.xlsx.StreamingReader;


public class MainStreamingReader {
	static Logger logger = Logger.getLogger(MainStreamingReader.class);

	public static void main(String[] args) throws IOException {
		procesarEjemplo();

	}
	
	private static void procesarEjemplo() {
		try {
			
	        //PropertyConfigurator.configure("log4j.properties");
			/*Properties properties = new Properties();
			properties.put("log4j.rootLogger", "DEBUG");
			properties.put("log4j.appender.A1", "org.apache.log4j.ConsoleAppender");
			properties.put("log4j.rootLogger", "DEBUG");
	        PropertyConfigurator.configure(properties);*/
	        
			File initialFile = new File("C:\\Users\\samy_\\Desktop\\HACIENDA\\moccfi\\PLANTILLA_MALA.xlsx");
			InputStream is = new FileInputStream(initialFile);
			Workbook workbook = StreamingReader.builder()
			          .rowCacheSize(100)
			          .bufferSize(4096)
			          .open(is);
			Sheet sheet=workbook.getSheetAt(0);
		    System.out.println(sheet.getSheetName());
		    for (Row r : sheet) {
			      for (Cell c : r) {
			        System.out.println(c.getStringCellValue());
			      }
			 }
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
