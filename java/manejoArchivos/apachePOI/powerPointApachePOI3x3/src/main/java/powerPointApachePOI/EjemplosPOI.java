package powerPointApachePOI;

import java.io.FileOutputStream;

import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFSlideShowImpl;
import org.apache.poi.sl.usermodel.PictureData;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hslf.model.PPGraphics2D;
import org.apache.poi.hslf.usermodel.HSLFGroupShape;
import org.apache.poi.hslf.usermodel.HSLFPictureData;
import org.apache.poi.hslf.usermodel.HSLFPictureShape;
import org.apache.poi.hslf.usermodel.HSLFShape;

public class EjemplosPOI {
	public void ejemploSimplePowerPoint() {
		try {
			// TODO Auto-generated method stub
			//create a new empty slide show
			HSLFSlideShow ppt = new HSLFSlideShow();
			//add first slide
			HSLFSlide s1 = ppt.createSlide();
			//add second slide
			HSLFSlide s2 = ppt.createSlide();
			//save changes in a file
			FileOutputStream out = new FileOutputStream("slideshow.ppt");
			ppt.write(out);
			out.close();
		}
		catch (Exception e){
			System.out.println("No se pudo procesar el archivo");
		}
		
	}
	public void ejemploImagenSimplePowerPoint() {
		try {
			HSLFSlideShow ppt = new HSLFSlideShow(new HSLFSlideShowImpl("slideshow.ppt"));
			// add a new picture to this slideshow and insert it in a new slide
			HSLFPictureData pd = ppt.addPicture(new File("clock2.jpg"), PictureData.PictureType.JPEG);
			HSLFPictureShape pictNew = new HSLFPictureShape(pd);
			// set image position in the slide
			pictNew.setAnchor(new java.awt.Rectangle(100, 100, 300, 200));
			HSLFSlide slide = ppt.createSlide();
			slide.addShape(pictNew);
			FileOutputStream out = new FileOutputStream("slideshow.ppt");
			ppt.write(out);
			out.close();
		}
		catch (Exception e){
			System.out.println("No se pudo procesar el archivo");
		}
		
	}
	public void ejemploImagenPowerPoint() {
		try {
			HSLFSlideShow ppt = new HSLFSlideShow(new HSLFSlideShowImpl("slideshow.ppt"));
			// extract all pictures contained in the presentation
			int idx = 1;
			for (HSLFPictureData pict : ppt.getPictureData()) {
			    // picture data
			    byte[] data = pict.getData();
			    PictureData.PictureType type = pict.getType();
			    String ext = type.extension;
			    FileOutputStream out = new FileOutputStream("pict_" + idx + ext);
			    out.write(data);
			    out.close();
			    idx++;
			}
			// add a new picture to this slideshow and insert it in a new slide
			HSLFPictureData pd = ppt.addPicture(new File("clock.jpg"), PictureData.PictureType.JPEG);
			HSLFPictureShape pictNew = new HSLFPictureShape(pd);
			// set image position in the slide
			pictNew.setAnchor(new java.awt.Rectangle(100, 100, 300, 200));
			HSLFSlide slide = ppt.createSlide();
			slide.addShape(pictNew);
			// now retrieve pictures containes in the first slide and save them on disk
			idx = 1;
			slide = ppt.getSlides().get(0);
			for (HSLFShape sh : slide.getShapes()) {
			    if (sh instanceof HSLFPictureShape) {
			        HSLFPictureShape pict = (HSLFPictureShape) sh;
			        HSLFPictureData pictData = pict.getPictureData();
			        byte[] data = pictData.getData();
			        PictureData.PictureType type = pictData.getType();
			        FileOutputStream out = new FileOutputStream("slide0_" + idx + type.extension);
			        out.write(data);
			        out.close();
			        idx++;
			    }
			}
			FileOutputStream out = new FileOutputStream("slideshow.ppt");
			ppt.write(out);
			out.close();
		}
		catch (Exception e){
			System.out.println("No se pudo procesar el archivo");
		}
		
	}
	public void ejemploDrawPowerPoint() {
		try {
			HSLFSlideShow ppt = new HSLFSlideShow();
			HSLFSlide slide = ppt.createSlide();
			// draw a simple bar graph
			// bar chart data.
			// The first value is the bar color,
			// the second is the width
			Object[] def = new Object[]{
			    Color.yellow, new Integer(100),
			    Color.green, new Integer(150),
			    Color.gray, new Integer(75),
			    Color.red, new Integer(200),
			};
			// all objects are drawn into a shape group so we need to create one
			HSLFGroupShape group = new HSLFGroupShape();
			// define position of the drawing in the slide
			Rectangle bounds = new java.awt.Rectangle(200, 100, 350, 300);
			// if you want to draw in the entire slide area then define the anchor
			// as follows:
			// Dimension pgsize = ppt.getPageSize();
			// java.awt.Rectangle bounds = new java.awt.Rectangle(0, 0,
			// pgsize.width, pgsize.height);
			group.setAnchor(bounds);
			slide.addShape(group);
			// draw a simple bar chart
			Graphics2D graphics = new PPGraphics2D(group);
			int x = bounds.x + 50, y = bounds.y + 50;
			graphics.setFont(new Font("Arial", Font.BOLD, 10));
			for (int i = 0, idx = 1; i < def.length; i += 2, idx++) {
			    graphics.setColor(Color.black);
			    int width = ((Integer) def[i + 1]).intValue();
			    graphics.drawString("Q" + idx, x - 20, y + 20);
			    graphics.drawString(width + "%", x + width + 10, y + 20);
			    graphics.setColor((Color) def[i]);
			    graphics.fill(new Rectangle(x, y, width, 30));
			    y += 40;
			}
			graphics.setColor(Color.black);
			graphics.setFont(new Font("Arial", Font.BOLD, 14));
			graphics.draw(bounds);
			graphics.drawString("Performance", x + 70, y + 40);
			FileOutputStream out = new FileOutputStream("hslf-graphics2d.ppt");
			ppt.write(out);
			out.close();
		}
		catch (Exception e){
			System.out.println("No se pudo procesar el archivo");
		}
		
	}
}
