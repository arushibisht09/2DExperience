package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	
	KeyHandler keyH = new KeyHandler() ; 
	Thread gameThread;// we are creating a new thread. It keeps the program going until stopped( this is like multithreading).
	
	//Player's default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4; 
	
	//constructor
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		// when set true the drawings from this component will be done in an offscreen painting buffer
		this.addKeyListener(keyH);
		this.setFocusable(true);
		// GamePanel can be "focused" to recieve key input.
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		// when we start the gameThread it automatically calls this method so we will create a game loop.
		while (gameThread != null) {
			
//			System.out.println("The game loop is running");
			
			// 1 UPDATE: update information such as character positions
			update();
			// 2 DRAW: draw the screen with the updated information.
			repaint(); // we call repaint() and then Java calls paintcomponent() for us automatically
		}
	}
	
	public void update() {
		
		// X value increases to the right
		// Y value increases as they go down
		
		
		if(keyH.upPressed == true) {
			playerY -= playerSpeed ; 
		}
		else if (keyH.downPressed == true) {
			playerY += playerSpeed ; 
		}
		else if (keyH.leftPressed == true) {
			playerX -= playerSpeed ; 
		}
		else if (keyH.rightPressed == true) {
			playerX += playerSpeed; 
		}
	}

	@Override 
	public void paintComponent(Graphics g) {
		// Graphics class - has many functions to draw objects on screen
		
		super.paintComponent(g);
		// clears the screen and sets up the drawing area properly before you start drawing your custom stuff.
		//If you don’t call super.paintComponent(g);, your new drawing might be layered on top of old frames,
		//which causes weird flickering or ghosting effects.
		
		Graphics2D g2 = (Graphics2D)g ;
		//Graphics2D has a bit more functions 
		
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();
		// saving memory
	}
}

// some notes for my knowledge :

// Java does not limit the number of interfaces you can implement .
// We have implemented Runnable as java only supports single inheritance and it
// lets us define the run() method - what the thread should do.
// by implementing the runnable class we can extend it to JPanel
// 1. when we do multithreading - we have no idea how the threads work(in which order).
// 2. If one thread runs into an exception , it will not affect others.
// With Runnable we just change the implementation of the run method and nothing else needs to be changed(except making a thread object).
