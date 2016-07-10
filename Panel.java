package main;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.Timer;
import javafx.embed.swing.JFXPanel;
import level.*;
import saves.Save;

public class Panel extends JFXPanel implements KeyListener, MouseListener, MouseMotionListener {
	// Class needs serialVersionUID
	private static final long serialVersionUID = 1L;

	// Current level, start at 0 (title)
	public static int level = 0;

	// Window size
	static Dimension windowsize = CommieQuest.frame.getBounds().getSize();
	public static int width = (int)windowsize.getWidth();
	public static int height = (int)windowsize.getHeight();

	// Create all levels
	Level title = new Title();
	Level[] levels = new Level[] {title};

	public static ArrayList<Save> saves;

	// Update the frame
	ActionListener update = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			windowsize = CommieQuest.frame.getBounds().getSize();
			width = (int)windowsize.getWidth();
			height = (int)windowsize.getHeight();
			levels[level].update();
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

		// Create all saves
		saves = new ArrayList<Save>();
		for (int i = 1; i < 6; i++) {
			try {
				FileInputStream fileIn = new FileInputStream("/saves/save" + i + ".ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				saves.add((Save)in.readObject());
				in.close();
				fileIn.close();
			} catch (IOException e) {
				saves.add(new Save(i));
			} catch (ClassNotFoundException c) {}
		}
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
		levels[level].paintComponent(g);
	}
}
