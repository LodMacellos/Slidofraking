package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class CommieQuest {
	public static JFrame frame;
	
	public static void main(String[] args) {
		// Creating new frame
		frame = new JFrame("Commie Quest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		// Adding panel
		Panel panel = new Panel();
		frame.add(panel, BorderLayout.CENTER);
		
		frame.setSize(900, 600);
		frame.setVisible(true);
	}
}
