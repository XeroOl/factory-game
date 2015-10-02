package main;

import javax.swing.JFrame;

import render.GameScreen;
import file.Options;

public class GameRunner {
	public static void main(String[] args) {
		// THIS IS A GAME MANAGER
		JFrame myJFrame = new JFrame();
		String[] vals = Options.options.readOption("res").split("x");
		myJFrame.setSize((int) Integer.valueOf(vals[0].trim()),
				(int) Integer.valueOf(vals[1].trim()));
		myJFrame.setVisible(true);
		myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJFrame.setTitle("My Game");
		myJFrame.add(GameScreen.gs);
		GameManager.gm.start();// STARTING WILL STEAL YOUR THREAD

	}
	// break, place, interact

}
