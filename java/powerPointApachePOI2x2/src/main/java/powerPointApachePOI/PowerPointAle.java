package powerPointApachePOI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.usermodel.HSLFPictureData;
import org.apache.poi.hslf.usermodel.HSLFPictureShape;
import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFSlideShowImpl;
import org.apache.poi.hslf.usermodel.HSLFTextBox;
import org.apache.poi.hslf.usermodel.HSLFTextParagraph;
import org.apache.poi.hslf.usermodel.HSLFTextRun;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;

public class PowerPointAle {
	private String rutaTrabajo = "C:\\Users\\samy_\\Desktop\\Ale\\trabajo";
	private String archivoPlantilla="C:\\Users\\samy_\\Desktop\\Ale\\plantilla.ppt";
	private int numeroImagen=0;
	HSLFSlide slide;
	
	public PowerPointAle(String rutaTrabajo,String archivoPlantilla) {
		this.rutaTrabajo = rutaTrabajo;
		this.archivoPlantilla=archivoPlantilla;
	}

	public PowerPointAle() {
	}

	public void generarPowerPointAle() {
		HSLFSlideShow ppt=null;
		try {
			ppt = new HSLFSlideShow(new HSLFSlideShowImpl(archivoPlantilla));
			slide= ppt.createSlide();
		} catch (IOException e) {
			System.out.println("La plantilla no existe");
		}

		// Directorio base de las imagenes
		File baseDir = new File(rutaTrabajo);
		File[] carpetasTrabajo = baseDir.listFiles(File::isDirectory);
		for (File carpeta : carpetasTrabajo) {
			System.out.println("Carpeta: " + carpeta.getName());
			File[] archivos = carpeta.listFiles();
			generarArchivo(archivos,ppt);
		}
	}

	private void generarArchivo(File[] archivos,HSLFSlideShow ppt) {
		try {
			
			for (File file : archivos) {
				if (file != null && file.getName().toLowerCase().endsWith(".jpg")) {
					System.out.println("Imagen: " + file.getAbsolutePath());
					if(numeroImagen%4==0 && numeroImagen!=0) {
						//Cada 4 imagenes se crea un nuevo Slide
						slide = ppt.createSlide();
					}
					//Se agrega la imagen a la diapositiva
					agregarImagen(ppt,slide,file,numeroImagen%4);
					numeroImagen++;
				}
			}
			
			FileOutputStream out = new FileOutputStream(rutaTrabajo+"\\salida.ppt");
			ppt.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Metodo usado para agregar una imagen en un Slide
	 * la posicion va del 0 al 3
	 * */
	private void agregarImagen(HSLFSlideShow ppt,HSLFSlide slide,File file,int posicion) throws IOException {
		final int ancho=255,alto=145,altoTexto=10,separacionImgTexto=5;
		final int x1=70,y1=120,x2=370,y2=310;
		int x=0,y=0;
		String ruta=file.getAbsolutePath();
		
		HSLFPictureData pd = ppt.addPicture(new File(ruta), PictureData.PictureType.JPEG);
		HSLFPictureShape pictNew = new HSLFPictureShape(pd);
		if(posicion==0) {
			x=x1;
			y=y1;
		}
		else if(posicion==1) {
			x=x2;
			y=y1;
		}
		else if(posicion==2){
			x=x1;
			y=y2;
		}
		else if(posicion==3){
			x=x2;
			y=y2;
		}
		pictNew.setAnchor(new java.awt.Rectangle(x, y, ancho,alto));
		pictNew.setShapeType(ShapeType.ROUND_RECT);

		//Se agrega el texto de la imagen
		HSLFTextBox txt = new HSLFTextBox();
		txt.setText(file.getParentFile().getName());
		txt.setAnchor(new java.awt.Rectangle(x,y+alto+separacionImgTexto, ancho, altoTexto));
		// use TextRun to work with the text format
		HSLFTextParagraph tp = txt.getTextParagraphs().get(0);
		tp.setTextAlign(TextAlign.CENTER);
		HSLFTextRun rt = tp.getTextRuns().get(0);
		rt.setFontSize(10.8);
		rt.setFontFamily("Liberation Sans");
		rt.setFontColor(Color.black);
		slide.addShape(txt);
		
		slide.addShape(pictNew);
	}
	
		
}
