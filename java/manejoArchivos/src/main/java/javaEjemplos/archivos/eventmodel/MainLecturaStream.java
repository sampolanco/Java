package javaEjemplos.archivos.eventmodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javaEjemplos.archivos.eventmodel.shetHandler.SheetHandler;


public class MainLecturaStream {

	private static SheetHandler handler;
	
	public static void main(String[] args) throws IOException {
		File initialFile = new File("C:\\Users\\samy_\\Desktop\\HACIENDA\\moccfi\\tabla_amortizacion_datos.xlsx");
		InputStream stream=null;
		try {
			stream = new FileInputStream(initialFile);
			boolean validoNuevo = validateEncabezadosNuevo(initialFile);
			System.out.println("validoNuevo: " + validoNuevo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

	}

	public static boolean validateEncabezadosNuevo(File file) throws IOException {

		OPCPackage container;
		try {
			container = OPCPackage.open(file.getAbsolutePath());
			XSSFReader xssfReader = new XSSFReader(container);
			SharedStringsTable strings = xssfReader.getSharedStringsTable();
			
			StylesTable styles = xssfReader.getStylesTable();
			XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
			while (iter.hasNext()) {
				InputStream stream = iter.next();

				processSheet(styles, strings, stream);
	            procesarLecturaExcel();

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
		} catch (RuntimeException e) {
			
		}
		
		return true;

	}
	protected static void processSheet(StylesTable styles, SharedStringsTable strings, InputStream sheetInputStream) throws IOException, SAXException {

        InputSource sheetSource = new InputSource(sheetInputStream);
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxFactory.newSAXParser();
            XMLReader sheetParser = saxParser.getXMLReader();
            handler = new SheetHandler(strings);
            sheetParser.setContentHandler(handler);
            try {
	            sheetParser.parse(sheetSource);
            }
            catch(Exception e) {}
            
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
     }
	
	private static void procesarLecturaExcel() {
        System.out.println("procesarLecturaExcel--");

		for (Map.Entry<Date, Double> entry : handler.mapTasas.entrySet()) {

			Date k = entry.getKey();
			Double v = entry.getValue();
            System.out.println("Fecha: "+k + " Pago: "+ v);
        }
	}
	/*
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
     */

}
