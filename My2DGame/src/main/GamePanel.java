package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

// we put JPanel inside a bigger window(that is JFrame)
//JPanel is a lightweight container used to group and organize components in a GUI.

public class GamePanel extends JPanel implements Runnable{
	// game panel will work as the game screen
	
	//SCREEN SETTING
	final int originalTileSize = 16 ; //16x16 tile
	//standard size for many retro 2D games 
	
	final int scale = 3 ;
	
	final int tileSize = originalTileSize * scale ; // 48x 48 tile
	
	final int maxScreenCol = 16; 
	final int maxScreenRow = 12;
	// ratio is 4:3
	
	final int screenWidth = tileSize * maxScreenCol ; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow ; // 576 pixels
	
	Thread gameThread;// something we can start and stop. It keeps the program going until stopped.
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		// when set true the drawings from this component will be done in an offscreen painting buffer 
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		// when we start the gameThread it automatically calls this method so we will create a game loop.
		
	}
}
