package level;

import java.awt.*;
import java.util.ArrayList;
import main.Panel;
import component.ImageResizeable;

public class Level {
	int width;
	int height;
	ArrayList<ImageResizeable> images = new ArrayList<ImageResizeable>();
	
	public void click(int x, int y){
		
	}
	
	public void mouseMove(int x, int y){
		
	}
	
	public void keyPress(int keyCode){
		
	}
	
	public void keyRelease(int keyCode){
		
	}
	
	public void resize(){
		// Detect changes in window width
		width = Panel.width;
		height = Panel.height;
	}
	
	public void paintComponent(Graphics g){
		// Paint all images in ArrayList images
		for (int i = 0; i < images.size(); i++) {
			ImageResizeable image = images.get(i);
			Image scaledImage = image.scaledImage();
			g.drawImage(scaledImage, image.x, image.y, null);
		}
	}
}
