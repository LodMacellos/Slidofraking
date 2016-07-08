package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class CommieQuest {
	public static void main(String[] args) {
		// Creating new frame
		JFrame frame = new JFrame("Commie Quest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		// Adding panel
		Panel panel = new Panel();
		frame.add(panel, BorderLayout.CENTER);
		
		// Fit window to screen
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}
