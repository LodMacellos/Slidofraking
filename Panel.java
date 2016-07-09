package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import level.*;

public class Panel extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
	// Class needs serialVersionUID
	private static final long serialVersionUID = 1L;
	
	public static int level = 0;
	
	// Create all levels
	Level title = new Title();
	Level[] levels = new Level[] {title};
	
	// Update the frame
	ActionListener update = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
			CommieQuest.width = (int)screensize.getWidth();
			CommieQuest.height = (int)screensize.getHeight();
			repaint();
		}
	};
	
	Panel(){	
		setBackground(Color.white);
	
		// Set update every 20 milliseconds
		Timer timer = new Timer(20, update);
		timer.start();
		
		// Creating event listeners
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
	}
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
	}
	
	public void keyReleased(KeyEvent e){
		int keyCode = e.getKeyCode();
	}
	
	public void mousePressed(MouseEvent e){
		int x = e.getX(), y = e.getY();
	}
	
	public void mouseMoved(MouseEvent e){
		int x = e.getX(), y = e.getY();
	}
	
	// Unused events
	public void keyTyped(KeyEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	
	// Paint the frame
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		levels[level].resize();
		levels[level].paint(g);
	}
}
