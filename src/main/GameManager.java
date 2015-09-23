package main;

import java.util.Random;

import menu.MenuScene;
import render.GameScreen;
import render.Scene;
import file.FileEditor;

public class GameManager {
	FileEditor options = new FileEditor("options.txt");
	GameScreen myGameScreen = new GameScreen();
	boolean keepRunning = true;
	Console console = new Console(System.out, Console.DEBUG);
	Scene s = new MenuScene(myGameScreen);

	public void printOptions() {
		System.out.println(options);
	}

	public void start() {
		myGameScreen.addMouseListener(s);
		while(keepRunning){
			myGameScreen.render(s);
			myGameScreen.requestFocus();
		}
	}
}
