package mx.sam.estructural.adapter.reproductormusica.clasesbuilder;

import mx.sam.estructural.adapter.reproductormusica.service.MediaPlayer;

public class ReproductorAudioAdapter implements MediaPlayer{

	MediaPlayerAvanzado mediaPlayerAvanzado;
	
	public ReproductorAudioAdapter(String tipoAudio) {
		if("vlc".equals(tipoAudio)) {
			mediaPlayerAvanzado=new ReproductorVlc();
		}
		else if("mp4".equals(tipoAudio)) {
			mediaPlayerAvanzado=new ReproductorMp4();
		}
		else{
			throw new RuntimeException("Tipo de audio no soportado");
		}

	}
	@Override
	public void play(String tipoDeAudio, String nombreArchivo) {
		if("vlc".equals(tipoDeAudio)) {
			mediaPlayerAvanzado.playVlc(nombreArchivo);
		}
		else if("mp4".equals(tipoDeAudio)) {
			mediaPlayerAvanzado.playMp4(nombreArchivo);
		}
		else{
			throw new RuntimeException("Tipo de audio no soportado");
		}
	}

}
