package main;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class GameRunner {
	public static void main(String[] args) {
		// THIS IS A GAME MANAGER
		GameManager myGameManager = new GameManager();

		JFrame myJFrame = new JFrame();

		String[] vals = myGameManager.options.readOption("res").split("x");
		myJFrame.setSize((int) Integer.valueOf(vals[0].trim()), (int) Integer.valueOf(vals[1].trim()));
		myJFrame.setVisible(true);
		myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJFrame.setTitle("My Game");
		myJFrame.add(myGameManager.myGameScreen);
		myGameManager.start();//STARTING WILL STEAL YOUR THREAD
		
	}
	// break, place, interact

}
