package main;

import javax.swing.JFrame;

import file.FileEditor;

public class GameRunner {
	public static void main(String[] args) {
		// THIS IS A GAME MANAGER
		JFrame myJFrame = new JFrame();
		String[] vals =FileEditor.options.readOption("res").split("x");
		myJFrame.setSize((int) Integer.valueOf(vals[0].trim()), (int) Integer.valueOf(vals[1].trim()));
		myJFrame.setVisible(true);
		myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJFrame.setTitle("My Game");
		myJFrame.add(GameManager.gm.myGameScreen);
		GameManager.gm.start();//STARTING WILL STEAL YOUR THREAD
		
	}
	// break, place, interact

}
