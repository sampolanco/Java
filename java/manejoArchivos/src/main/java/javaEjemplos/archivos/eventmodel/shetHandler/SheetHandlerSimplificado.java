package javaEjemplos.archivos;

import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SheetHandlerSimplificado extends DefaultHandler{
	private ReadOnlySharedStringsTable sharedStringsTable;
	private String lastContents;
	private boolean nextIsString;

	public SheetHandlerSimplificado(ReadOnlySharedStringsTable sharedStringsTable) {
		this.sharedStringsTable = sharedStringsTable;
	}

	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {	
        if(name.equals("c")) {
            // Print the cell reference
            System.out.println(attributes.getValue("r") + " - ");
            // Figure out if the value is an index in the SST
            String cellType = attributes.getValue("t");
            if(cellType != null && cellType.equals("s")) {
                nextIsString = true;
            } else {
                nextIsString = false;
            }
        }
        // Clear contents cache
        lastContents = "";
	}

    public void endElement(String uri, String localName, String name)
            throws SAXException {
        if(nextIsString) {
            int idx = Integer.parseInt(lastContents);
            lastContents=sharedStringsTable.getEntryAt(idx).toString();
            //lastContents = new XSSFRichTextString(sharedStringsTable.getEntryAt(idx)).toString();
            nextIsString = false;
        }
        if(name.equals("v")) {
            System.out.println("     Contenido: "+lastContents);
        }
    }
    public void characters(char[] ch, int start, int length) {
        lastContents += new String(ch, start, length);
    }
}
