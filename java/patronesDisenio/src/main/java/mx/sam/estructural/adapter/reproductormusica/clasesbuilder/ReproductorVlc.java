package mx.sam.estructural.adapter.reproductormusica.clasesbuilder;

public class ReproductorVlc  implements MediaPlayerAvanzado{

	@Override
	public void playVlc(String nombreArchivo) {
	    System.out.println("Reproduciendo audio de VLC "+ nombreArchivo);	
		
	}

	@Override
	public void playMp4(String nombreArchivo) {
	    System.out.println("Audio no compatible");	
	}
}
