package javaEjemplos.archivos;


import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ValidarEncabezadosViejo {
	public boolean validateEncabezados(final String encs[], final InputStream archivo) {
		XSSFWorkbook book = null;
		XSSFSheet sheet = null;
		XSSFRow row = null;
		XSSFCell cell = null;

		try {
			book = new XSSFWorkbook(archivo);
			sheet = book.getSheetAt(0);
			row = sheet.getRow(0);

			for (int idx = 0; idx < encs.length; idx++) {
				cell = row.getCell(idx);
				if (cell == null || !cell.getStringCellValue().equals(encs[idx])) {
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("Error al abrir el archivo xlsx");
			return false;
		}

		return true;
	}
}
