package main;

import javax.swing.JFrame;

import render.GameScreen;
import world.Data;
import world.item.Item;
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
		Data itemdata = new Data("world.item.ItemOne:{5,world.item.ItemOne:{5,g,hgeh},\"hgeh\"}");
		Item i = itemdata.toType(Item.class);
		Item i2 = itemdata.readMetaData().get(1).toType(Item.class);
		Data doubledata = new Data("254.524");
		double d = doubledata.toDouble();
		
	}
	// break, place, interact

}
