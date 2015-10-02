package menu;

import gui.Button;
import gui.Layer;
import render.DrawableObject;
import render.Scene;

public class MenuScene extends Scene {


	
	public MenuScene() {

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
