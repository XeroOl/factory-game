package menu;

import gui.Button;
import gui.Layer;
import render.DrawableObject;
import render.GameScreen;
import render.Scene;

public class MenuScene extends Scene {
	public MenuScene(GameScreen g) {
		mainMenu.add(new Button(50, 50, 800, 100, "Open a world") {
			public void action() {
				layers.clear();
				layers.add(worldSelect);
				layers.add(background);
			}
		});
		mainMenu.add(new Button(50, 200, 800, 100, "Options") {
			public void action() {
				layers.clear();
				layers.add(options);
				layers.add(background);
			}
		});
		mainMenu.add(new Button(50, 350, 800, 100, "Select Language") {
			public void action() {
				layers.clear();
				layers.add(languageSelect);
				layers.add(background);
			}
		});
		mainMenu.add(new Button(50, 500, 800, 100, "Quit") {
			public void action() {
				System.exit(0);
			}
		});
		background.add(new Button(0,0,1920,1080,""));
		myScreen = g;
		layers.add(mainMenu);
		layers.add(background);
	}
	Layer background = new Layer();
	Layer mainMenu = new Layer();
	Layer options = new Layer();
	Layer languageSelect = new Layer();
	Layer worldSelect = new Layer();

	@Override
	public void leftClick(int x, int y) {
		all: for (Layer l : layers) {
			for (DrawableObject m : l) {
				if (m instanceof Button && m.contains(x, y)) {
					((Button) m).action();
				
					break all;
				}
			}
		}
	}

	@Override
	public void rightClick(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void middleClick(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scroll(int wheelRotation, int x, int y) {
		// TODO Auto-generated method stub

	}
}
