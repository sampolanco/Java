package javaEjemplos.archivos;

import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/** sheet handler class for SAX2 events */
public class SheetHandler extends DefaultHandler {
	private SharedStringsTable sharedStringsTable;
	private String contents;
	private boolean isCellValue;
	private boolean fromSST;

	public SheetHandler(SharedStringsTable sharedStringsTable) {
		this.sharedStringsTable = sharedStringsTable;
	}

	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		// element row represents Row
		// attribute r represents the cell reference
		// attribute t represents the cell type
		// element c represents Cell
		// element v represents value of Cell
		// Clear contents cache
		contents = "";				
		System.out.println("name: "+name+" , ");
		// element row represents Row
		if (name.equals("row")) {
			String rowNumStr = attributes.getValue("r");
			System.out.println("Row# " + rowNumStr);
		}		
		// element c represents Cell
		else if (name.equals("c")) {
			System.out.println("     r: "+attributes.getValue("r") + " - ");
			String cellType = attributes.getValue("t");
			
		    System.out.println("          ---Atributos---");
			for(int i = 0; i < attributes.getLength(); i++) {
			    System.out.println("          "+attributes.getValue(i));
			}
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
	
	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		if (isCellValue && fromSST) {
			int index = Integer.parseInt(contents);
			contents = new XSSFRichTextString(sharedStringsTable.getEntryAt(index)).toString();
			System.out.println("     contenido: "+contents);
			isCellValue = false;
			fromSST = false;
		}
		if(name.equals("v")) {
			System.out.println("     contenido: "+contents);
        }
	}
}