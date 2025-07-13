package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame() ; 
		//JFrame allows us to create and manage the main window or screen of a Java program that has a visual interface.
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// telling our JFrame window what to do when the user clicks X 
		
		window.setResizable(false);
		window.setTitle("2D Experience");
		
		window.setLocationRelativeTo(null);
		//Positions the JFrame relative to the specified component. If null, it centers the frame on the screeen.
		
		window.setVisible(true);
	}

}
