package mx.sam.estructural.adapter.reproductormusica;

import mx.sam.estructural.adapter.reproductormusica.service.ReproductorAudio;

public class Main {

	public static void main(String[] args) {
		ReproductorAudio audioPlayer = new ReproductorAudio();

		audioPlayer.play("mp3", "archivo.mp3");
		audioPlayer.play("mp4", "archivo.mp4");
		audioPlayer.play("vlc", "archivo.vlc");
		audioPlayer.play("avi", "archivo.avi");
	}

}
