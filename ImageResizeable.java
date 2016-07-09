package component;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageResizeable {
	public ImageIcon image;
	Image scaledImage;
	public int x, y;
	int width, height;
	
	public ImageResizeable(String imagePath, int x, int y, int width, int height){
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("resources/" + imagePath));
		} catch (IOException e) {}
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		scaledImage = image.getScaledInstance(width, height, Image.SCALE_FAST);
	}
	
	public Image scaledImage(){
		return scaledImage;
	}
}
