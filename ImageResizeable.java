package component;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageResizeable {
	BufferedImage image = null;
	public int x, y;
	int width, height;
	
	public ImageResizeable(String imagePath, int x, int y, int width, int height){
		// Create unscaled image
		try {
			image = ImageIO.read(new File("resources/" + imagePath));
		} catch (IOException e) {}
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Image scaledImage(){
		// Scale image based on given height and width
		return image.getScaledInstance(width, height, Image.SCALE_FAST);
	}
}
