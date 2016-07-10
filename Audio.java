package media;

import java.io.File;
import javafx.scene.media.*;
import javafx.util.Duration;

public class Audio {
	Media audio;
	MediaPlayer playAudio;

	public Audio(String filePath){
		audio = new Media(new File("resources/" + filePath).toURI().toString());
		playAudio = new MediaPlayer(audio);
	}

	public void play(){
		playAudio.play();
	}

	public void stop(){
		playAudio.stop();
	}

	public void loop(){
		playAudio.play();
		playAudio.setOnEndOfMedia(new Runnable() {
			public void run() {
				playAudio.seek(Duration.ZERO);
				playAudio.play();
			}
		});
	}
}
