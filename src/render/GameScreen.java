package render;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import main.GameManager;

public class GameScreen extends Canvas {
	private static final long serialVersionUID = -4065831316512810103L;
	BufferStrategy m;
	public static GameScreen gs = new GameScreen();
	int xscale = 1920;
	int yscale = 1080;

	public GameScreen() {
	}

	public void paint(Graphics g) {
		render();
	}

	public void render() {
		Scene s = GameManager.gm.s;
		if (m == null) {
			createBufferStrategy(2);
			m = getBufferStrategy();
		}
		Graphics g = m.getDrawGraphics();
		g.setClip(0, 0, 1920, 1080);
		for (int i = s.layers.size() - 1; i >= 0; i--) {
			for (DrawableObject element : s.layers.get(i)) {
				element.drawImage(g);
			}
		}

		m.show();
		g.dispose();
	}

}
