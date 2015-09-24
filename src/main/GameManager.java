package main;

import menu.MenuScene;
import render.GameScreen;
import render.Scene;
import file.FileEditor;

public class GameManager {
	public static GameManager gm = new GameManager();
	GameScreen myGameScreen = new GameScreen();
	boolean keepRunning = true;
	Console console = new Console(System.out, Console.DEBUG);
	Scene s = new MenuScene();

	public void printOptions() {
		System.out.println(FileEditor.options);
	}

	public void start() {
		myGameScreen.addMouseListener(s);
		myGameScreen.addMouseMotionListener(s);
		myGameScreen.addMouseWheelListener(s);
	}
}
