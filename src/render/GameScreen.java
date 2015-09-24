package render;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferStrategy;

public class GameScreen extends Canvas {
	private static final long serialVersionUID = -4065831316512810103L;
	BufferStrategy m;
	public static GameScreen gs = new GameScreen();

	public GameScreen() {
	}

	public void render(Scene s) {
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
