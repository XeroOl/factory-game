package main;

import menu.MenuScene;
import render.GameScreen;
import render.Scene;
import world.item.Item;
import file.Options;

public class GameManager {
	public static GameManager gm = new GameManager();
	GameScreen myGameScreen = GameScreen.gs;
	boolean keepRunning = true;
	Console console = new Console(System.out, Console.DEBUG);
	public Scene s = new MenuScene();

	public void printOptions() {
		System.out.println(Options.options);
	}

	public void start() {
		myGameScreen.addMouseListener(s);
		myGameScreen.addMouseMotionListener(s);
		myGameScreen.addMouseWheelListener(s);
		myGameScreen.render();
		Item i = Item.fromString("Bag:{<INVENTORY CODE>}");
		((world.item.ItemOne)i).shout();
	}
}
