package javaEjemplos.archivos.eventmodel;


import java.io.InputStream;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.sax.SAXSource;

import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javaEjemplos.archivos.eventmodel.shetHandler.SheetHandler;


public class LeerArchivoEventModel {
	public boolean validateEncabezados(final String encs[], final InputStream archivo) {


		try {

			OPCPackage pkg = OPCPackage.open(archivo);
			XSSFReader r = new XSSFReader(pkg);
		    SharedStringsTable sst = r.getSharedStringsTable();
		    XMLReader parser = fetchSheetParser(sst);
		    
		    //Iterator<InputStream> sheets=r.getSheetsData();
		    SheetIterator sheets = (SheetIterator) r.getSheetsData();
		    InputStream sheet1 = sheets.next();
	        InputSource sheetSource = new InputSource(sheet1);
	        	        
	        //Procesa el archivo
	        parser.parse(sheetSource);
			System.out.println("Parseo finalizado");

	        sheet1.close();
		} catch (Exception e) {
			System.out.println("Error al abrir el archivo xlsx");
			return false;
		}

		return true;
	}
    private XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser =
                XMLReaderFactory.createXMLReader(
                "com.sun.org.apache.xerces.internal.parsers.SAXParser");
        ContentHandler handler = new SheetHandler(sst);
        parser.setContentHandler(handler);
        return parser;
    }
}
