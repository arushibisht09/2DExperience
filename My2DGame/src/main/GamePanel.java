package main;

import javax.swing.JPanel;

// we put JPanel inside a bigger window(that is JFrame)
//JPanel is a lightweight container used to group and organize components in a GUI.

public class GamePanel extends JPanel{
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
	
}
