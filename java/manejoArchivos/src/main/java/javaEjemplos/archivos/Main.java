package javaEjemplos.archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class Main {

	public static void main(String[] args) throws IOException {
		File initialFile = new File("E:\\HACIENDA\\MOCCFI\\documentos prueba\\PLANTILLA_MALA.xlsx");
		InputStream stream;
		try {
			stream = new FileInputStream(initialFile);
			boolean validoNuevo = validateEncabezadosNuevo(initialFile);
			System.out.println("validoNuevo: " + validoNuevo);
			//boolean valido = validateEncabezados(new String[] { "Fecha", "Tasa variable" }, stream);
			//System.out.println("Valido: " + valido);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean validateEncabezadosNuevo(File file) throws IOException {

		OPCPackage container;
		try {
			container = OPCPackage.open(file.getAbsolutePath());
			XSSFReader xssfReader = new XSSFReader(container);
			//ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(container);
			SharedStringsTable strings = xssfReader.getSharedStringsTable();
			
			StylesTable styles = xssfReader.getStylesTable();
			XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
			while (iter.hasNext()) {
				InputStream stream = iter.next();

				processSheet(styles, strings, stream);
				stream.close();
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return false;
		} catch (SAXException e) {
			e.printStackTrace();
			return false;
		} catch (OpenXML4JException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}
	protected static void processSheet(StylesTable styles, SharedStringsTable strings, InputStream sheetInputStream) throws IOException, SAXException {

        InputSource sheetSource = new InputSource(sheetInputStream);
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxFactory.newSAXParser();
            XMLReader sheetParser = saxParser.getXMLReader();
            ContentHandler handler = new SheetHandler(strings);
            sheetParser.setContentHandler(handler);
            sheetParser.parse(sheetSource);
            
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
     }
	protected static void processSheetSimplificado(StylesTable styles, ReadOnlySharedStringsTable strings, InputStream sheetInputStream) throws IOException, SAXException {

        InputSource sheetSource = new InputSource(sheetInputStream);
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxFactory.newSAXParser();
            XMLReader sheetParser = saxParser.getXMLReader();
            ContentHandler handler = new SheetHandlerSimplificado(strings);
            sheetParser.setContentHandler(handler);
            sheetParser.parse(sheetSource);
            
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
     }

}
