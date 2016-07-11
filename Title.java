package level;

import java.awt.*;
import java.util.Date;
import main.Panel;
import media.*;

public class Title extends Level {
	int heightImg, xImg;
	ImageResizeable intro, credits, home;
	long initTime = new Date().getTime();
	Audio introMusic = new Audio("intro.mp3");
	Audio homeMusic = new Audio("home.mp3");
	int hoverSave = -1;

	public Title(){
		introMusic.play();
	}

	public void click(int x, int y){
		int imgHeight = height - 50;
		int imgWidth = 4 / 3 * imgHeight;
		if (x > imgWidth / 6 + (width - imgWidth) / 2 &&
				x < 5 * imgWidth / 6 + (width - imgWidth) / 2) {
			for (int i = 0; i < 5; i++) {
				if (y > (3 * i + 11) * imgHeight / 30 &&
						y < (3 * i + 11) * imgHeight / 30 + imgHeight / 15) {
					homeMusic.stop();
					Panel.level = Panel.saves.get(i).level;
					return;
				}
			}
		}
	}

	public void mouseMove(int x, int y){
		int imgHeight = height - 50;
		int imgWidth = 4 / 3 * imgHeight;
		if (x > imgWidth / 6 + (width - imgWidth) / 2 &&
				x < 5 * imgWidth / 6 + (width - imgWidth) / 2) {
			for (int i = 0; i < 5; i++) {
				if (y > (3 * i + 11) * imgHeight / 30 &&
						y < (3 * i + 11) * imgHeight / 30 + imgHeight / 15) {
					hoverSave = i;
					return;
				}
			}
		}
		hoverSave = -1;
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
		if (initTime + 6000 > new Date().getTime()) {
			// Background color
			g.setColor(new Color(0, 47, 123));
			g.fillRect(0, 0, width, height);

			super.paintComponent(g);
		} else {
			// Background color
			g.setColor(new Color(255, 240, 240));
			g.fillRect(0, 0, width, height);

			super.paintComponent(g);

			g.setFont(new Font("Courier New", Font.BOLD, height / 25));
			for (int i = 0; i < 5; i++) {
				g.setColor(Color.black);
				if (hoverSave == i)
					g.setColor(new Color(150, 150, 150));
				int imgHeight = height - 50;
				int imgWidth = 4 / 3 * imgHeight;
				int x = imgWidth / 6 + (width - imgWidth) / 2;
				int y = (3 * i + 11) * imgHeight / 30 + imgHeight / 20;
				g.drawString("Save " + (i + 1) + " - Level " + Panel.saves.get(i).level, x, y);
			}
		}
	}
}
