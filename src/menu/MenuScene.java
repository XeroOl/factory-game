package menu;

import file.FileEditor;
import file.ImageReader;
import gui.Button;
import gui.GuiImage;
import gui.Layer;
import main.Console;
import render.DrawableObject;
import render.GameScreen;
import render.Scene;

public class MenuScene extends Scene {
	MenuScene me = this;
	Layer mainMenu = new Layer(new Button(710, 540, 500, 100, "PLAY") {
		public void action() {
			Console.console.debug("Play world");
			GameScreen.gs.render(me);
		}
	}, new Button(710, 690, 500, 100, "OPTIONS") {
		public void action() {
			layers.set(0, optionsMenu);
			GameScreen.gs.render(me);
		}
	}, new Button(710, 840, 500, 100, "QUIT") {
		public void action() {
			System.exit(0);
		}
	});

	Layer optionsMenu = new Layer(new Button(710, 540, 500, 100,
			"RESOLUTION OPTION DOESN'T APPLY PROPERLY!!") {
		public void action() {
			FileEditor.options
					.writeVariable(
							"res",
							new String[] { "1920x1080", "1280x720", "1024x768" }[toggle(
									"Resolution: 1920 x 1080",
									"Resolution: 1280 x 720",
									"Resolution: 1024 x 768")]);
		}
	},new Button(710, 690, 500, 100,
			"Back to main menu") {
		public void action() {
			layers.set(0, mainMenu);
		}
	},new Button(710, 840, 500, 100,
			"Difficulty: Easy (literally cheating)") {
		public void action() {
			FileEditor.options
					.writeVariable(
							"res",
							new String[] { "EASY", "NORMAL", "HARD" }[toggle(
									"Difficulty: Easy (literally cheating)",
									"Difficulty: Normal (recommended)",
									"Difficulty: Hard (stupidly annoying)")]);
		}
	});
	Layer languageMenu = new Layer();
	Layer backgroundLayer = new Layer(new GuiImage(0, 0, 1920, 1080,
			ImageReader.getImage("assets/misc/background.png")));

	public MenuScene() {
		layers.add(mainMenu);
		layers.add(backgroundLayer);
	}

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

	@Override
	public void hover(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
