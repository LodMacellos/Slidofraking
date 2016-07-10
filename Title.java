package level;

import java.awt.*;
import java.util.Date;
import media.*;

public class Title extends Level {
	int heightImg, xImg;
	ImageResizeable intro, credits, home;
	long initTime = new Date().getTime();
	Audio introMusic = new Audio("intro.mp3");
	Audio homeMusic = new Audio("home.mp3");

	public Title(){
		introMusic.play();
	}

	public void update(){
		super.update();

		// Resize all images to fit screen size
		heightImg = height - 50;
		xImg = width / 2 - heightImg * 2 / 3;

		// Add or replace images in images array
		if (initTime + 3000 > new Date().getTime()) {
			intro = new ImageResizeable("intro.png", xImg, 0, -1, heightImg);
			if (images.size() > 0)
				images.set(0, intro);
			else
				images.add(intro);
		} else if (initTime + 6000 > new Date().getTime()) {
			credits = new ImageResizeable("credits.png", xImg, 0, -1, heightImg);
			images.set(0, credits);
		} else {
			if (images.get(0) == credits)
				homeMusic.loop();
			home = new ImageResizeable("home.png", xImg, 0, -1, heightImg);
			images.set(0, home);
		}
	}

	public void paintComponent(Graphics g){
		// Background color
		if (initTime + 6000 > new Date().getTime())
			g.setColor(new Color(0, 47, 123));
		else
			g.setColor(new Color(255, 240, 240));
		g.fillRect(0, 0, width, height);

		super.paintComponent(g);
	}
}
