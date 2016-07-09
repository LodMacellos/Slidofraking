package level;

import java.awt.*;
import component.ImageResizeable;

public class Title extends Level {
	int heightIntro, xIntro;
	ImageResizeable intro;
	
	public void resize(){
		// Resize all images to fit screen size
		super.resize();
		heightIntro = height - 50;
		xIntro = width / 2 - heightIntro * 2 / 3;
		intro = new ImageResizeable("intro.png", xIntro, 0, -1, heightIntro);
		
		// Add or replace images in images array
		if (images.size() > 0)
			images.set(0, intro);
		else {
			images.add(intro);
		}
	}
	
	public void paintComponent(Graphics g){
		// Background color
		g.setColor(new Color(0, 47, 123));
		g.fillRect(0, 0, width, height);
		
		super.paintComponent(g);
	}
}
