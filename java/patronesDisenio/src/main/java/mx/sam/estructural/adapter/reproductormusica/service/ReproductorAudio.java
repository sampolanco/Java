package mx.sam.estructural.adapter.reproductormusica.service;

import mx.sam.estructural.adapter.reproductormusica.clasesbuilder.ReproductorAudioAdapter;

public class ReproductorAudio implements MediaPlayer {
	ReproductorAudioAdapter reproductorAudioAdapter;

	@Override
	public void play(String tipoDeAudio, String nombreArchivo) {
		if ("mp3".equals(tipoDeAudio)) {
			System.out.println("Reproduciendo audio de MP3 " + nombreArchivo);
		} else if ("mp4".equals(tipoDeAudio) || "vlc".equals(tipoDeAudio)) {
			reproductorAudioAdapter = new ReproductorAudioAdapter(tipoDeAudio);
			reproductorAudioAdapter.play(tipoDeAudio, nombreArchivo);
		} else {
			throw new RuntimeException("Tipo de audio no soportado");
		}
	}

}
