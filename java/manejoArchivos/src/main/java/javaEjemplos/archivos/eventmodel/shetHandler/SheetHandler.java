package javaEjemplos.archivos.eventmodel.shetHandler;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ibm.icu.text.SimpleDateFormat;


/** sheet handler class for SAX2 events */
public class SheetHandler extends DefaultHandler {
	public boolean formatoCorrecto;
	public Map<Date, Double> mapTasas = null;
	Date nuevaFecha;
	Double nuevoPago;
	
	private SharedStringsTable sharedStringsTable;
	private String contents;
	private boolean isCellValue;
	private boolean fromSST;
	private String rowNumStr;
	private String posicionCelda;
	private int filaActual=0;

	public SheetHandler(SharedStringsTable sharedStringsTable) {
		System.out.println("Constructor SheetHandler");
		this.sharedStringsTable = sharedStringsTable;
		mapTasas = new HashMap<Date, Double>();
		nuevaFecha=null;
		nuevoPago=0D;
	}

	//Se va a leer el dato. Se verificael tipo de valor
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		// element row represents Row
		// attribute r represents the cell reference
		// attribute t represents the cell type
		// element c represents Cell
		// element v represents value of Cell
		// Clear contents cache
		contents = "";				
		//System.out.println("name: "+name+" , ");
		// element row represents Row
		if (name.equals("row")) {
			rowNumStr = attributes.getValue("r");
			filaActual++;
			//System.out.println("Row# " + rowNumStr);
		}		
		// element c represents Cell
		else if (name.equals("c")) {
			posicionCelda = attributes.getValue("r");
			//System.out.println("     r: "+attributes.getValue("r") + " - ");
			String cellType = attributes.getValue("t");
			
		    //System.out.println("          ---Atributos---");
			/*for(int i = 0; i < attributes.getLength(); i++) {
			    System.out.println("          "+attributes.getValue(i));
			}*/
			if (cellType != null && cellType.equals("s")) {
				// cell type s means value will be extracted from SharedStringsTable
				fromSST = true;
			} 
		// element v represents value of Cell	
		} else if (name.equals("v")) {
			isCellValue = true;
		}
		contents="";
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (isCellValue) {
			contents += new String(ch, start, length);	
		}
	}		
	
	//Ya se leyo el dato y está guardado en content
	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		if (isCellValue && fromSST) {
			int index = Integer.parseInt(contents);
			contents = new XSSFRichTextString(sharedStringsTable.getEntryAt(index)).toString();
			System.out.println("     contenido fromSST ");
			procesarCelda();
			isCellValue = false;
			fromSST = false;
		}
		else if(name.equals("v")) {
			procesarCelda();
        }
	}
	
	private void procesarCelda() {
        String letraColumna=posicionCelda.substring(0,1);
		//System.out.println("     contenido de row : "+posicionCelda + "="+contents+ " fila "+filaActual);
		if("A".equals(letraColumna) && filaActual>1) {
			//FechaPago
			nuevaFecha=null;
			nuevoPago=0D;
			SimpleDateFormat dtf=new SimpleDateFormat("dd/mm/yyyy");
			try {
				nuevaFecha= DateUtil.getJavaDate(Double.parseDouble(contents));
			} catch (Exception e) {
				
			}
		}
		else if("B".equals(letraColumna) && filaActual>1) {
			try {
				nuevoPago=Double.parseDouble(contents);
				mapTasas.put(nuevaFecha, nuevoPago);
			}
			catch(Exception e) {
				
			}
		}
		if(filaActual>10) {
			throw new RuntimeException("contador>1 ");
		}
	}
}