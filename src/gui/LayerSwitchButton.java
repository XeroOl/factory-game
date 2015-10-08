package gui;

import main.GameManager;


public class LayerSwitchButton extends Button {
	Layer l;
	public LayerSwitchButton(int x, int y, int width, int height, String text, Layer addMe) {
		super(x, y, width, height, text);
		l = addMe;
	}

	public void action() {
		GameManager.gm.s.layers.add(l);
	}
}
