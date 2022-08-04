package mx.sam.estructural.adapter.reproductormusica.clasesbuilder;

public class ReproductorMp4 implements MediaPlayerAvanzado{

	@Override
	public void playVlc(String nombreArchivo) {
	    System.out.println("Audio no compatible");	
	}

	@Override
	public void playMp4(String nombreArchivo) {
	    System.out.println("Reproduciendo audio de MP4 "+ nombreArchivo);	
	}

}
