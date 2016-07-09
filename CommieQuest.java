package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class CommieQuest {
	static Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = (int)screensize.getWidth();
	public static int height = (int)screensize.getHeight() - 100;
	
	public static void main(String[] args) {
		// Creating new frame
		JFrame frame = new JFrame("Commie Quest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		// Adding panel
		Panel panel = new Panel();
		frame.add(panel, BorderLayout.CENTER);
		
		// Fit window to screen
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}
