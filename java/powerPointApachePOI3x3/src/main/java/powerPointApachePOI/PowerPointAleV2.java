package powerPointApachePOI;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFAutoShape;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.xmlbeans.XmlObject;

import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;

public class PowerPointAleV2 {
	private String rutaTrabajo = "trabajo";
	private String archivoPlantilla="plantilla.pptx";
	private int numeroImagen=0;
	XSLFSlide slide;
	
	public PowerPointAleV2(String rutaTrabajo,String archivoPlantilla) {
		this.rutaTrabajo = rutaTrabajo;
		this.archivoPlantilla=archivoPlantilla;
	}

	public PowerPointAleV2() {
	}

	public void generarPowerPointAle() {
		XMLSlideShow ppt=null;
		int errores=0;

		try {
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);
			ppt = new XMLSlideShow(new FileInputStream(archivoPlantilla));
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
			errores=errores+generarArchivo(archivos,ppt);
		}
		JOptionPane.showMessageDialog(null, "Reporte terminado. con " +errores+ " errores");
	}

	private int generarArchivo(File[] archivos,XMLSlideShow ppt) {
		int errores=0;
		try {
			for (File file : archivos) {
				if (file != null && file.getName().toLowerCase().endsWith(".jpg")) {
					System.out.println("Imagen: " + file.getAbsolutePath());
					if(numeroImagen%6==0 && numeroImagen!=0) {
						//Cada 4 imagenes se crea un nuevo Slide
						slide = ppt.createSlide();
					}
					//Se agrega la imagen a la diapositiva
					agregarImagen(ppt,slide,file,numeroImagen%6);
					numeroImagen++;
				}
			}
			
			FileOutputStream out = new FileOutputStream(rutaTrabajo+"\\salida.pptx");
			ppt.write(out);
			out.close();
		} catch (Exception e) {
			errores++;
			e.printStackTrace();
			// System.out.println(e.getMessage());
		}
		return errores;
	}
	
	/*
	 * Metodo usado para agregar una imagen en un Slide
	 * la posicion va del 0 al 3
	 * */
	private void agregarImagen(XMLSlideShow ppt,XSLFSlide slide,File file,int posicion) throws IOException {
		final int ancho=210,alto=115,altoTexto=10,separacionImgTexto=5;
		final int x1=30,x2=261,x3=492,y1=120,y2=310;
		int x=0,y=0;
		String ruta=file.getAbsolutePath();
		
		File imagen=new File(ruta);
		
		XSLFPictureData pd = ppt.addPicture(imagen, PictureData.PictureType.JPEG);
		XSLFPictureShape pictNew =slide.createPicture(pd);
		if(posicion==0) {
			x=x1;
			y=y1;
		}
		else if(posicion==1) {
			x=x2;
			y=y1;
		}
		else if(posicion==2){
			x=x3;
			y=y1;
		}
		else if(posicion==3){
			x=x1;
			y=y2;
		}
		else if(posicion==4) {
			x=x2;
			y=y2;
		}
		else if(posicion==5){
			x=x3;
			y=y2;
		}
		
		pictNew.setAnchor(new java.awt.Rectangle(x, y, ancho,alto));
		pictNew.setShapeType(ShapeType.ROUND_RECT);
		setRadius(pictNew, 15); //50% radius

		String nombreImagen=file.getParentFile().getName();
		String[] nombre=file.getParentFile().getName().split("_");
		if(nombre.length==0)
			throw new IllegalArgumentException(nombreImagen);
		nombreImagen=nombreImagen.replaceFirst(nombre[0]+"_", "");
		
		//Se agrega el texto de la imagen
		XSLFTextBox txt = slide.createTextBox();
		txt.setText(nombreImagen);
		txt.setAnchor(new java.awt.Rectangle(x,y+alto+separacionImgTexto, ancho, altoTexto));
		// use TextRun to work with the text format
		XSLFTextParagraph tp = txt.getTextParagraphs().get(0);
		tp.setTextAlign(TextAlign.CENTER);
		XSLFTextRun rt = tp.getTextRuns().get(0);
		rt.setFontSize(10.8);
		rt.setFontFamily("Liberation Sans");
		rt.setFontColor(Color.black);
	}
	
	
	 static void setRadius(XSLFPictureShape autoShape, int percent) {
		  if (ShapeType.ROUND_RECT.equals(autoShape.getShapeType())) {
		   XmlObject xmlObject = autoShape.getXmlObject();
		   CTPicture ctShape = (CTPicture)xmlObject;
		   CTGeomGuideList ctGeomGuideList = ctShape.getSpPr().getPrstGeom().getAvLst();
		   CTGeomGuide ctGeomGuide = ctGeomGuideList.addNewGd();
		   ctGeomGuide.setName("adj");
		   ctGeomGuide.setFmla("val " + (50000*percent/100));
		  }
		 }

}
