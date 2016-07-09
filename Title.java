package level;

import java.awt.*;
import javax.swing.*;

public class Title extends Level {
	ImageIcon intro = new ImageIcon("resources/intro.png");
	Image scaleIntro = intro.getImage().getScaledInstance((height - 50) * 4 / 3, height - 50, Image.SCALE_DEFAULT);
	
	public void resize(){
		
	}
	
	public void paint(Graphics g){
		g.setColor(new Color(0, 47, 123));
		g.fillRect(0, 0, width, height);
		g.drawImage(scaleIntro, width / 2 - height * 2 /3, 0, null);
	}
}
