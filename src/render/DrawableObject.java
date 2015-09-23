package render;

import java.awt.Graphics;
import java.awt.Image;

public class DrawableObject {
	protected int drawX;
	protected int drawY;
	protected int drawWidth;
	protected int drawHeight;
	protected Image drawImage;
	public void drawImage(Graphics g) {
		g.drawImage(drawImage, drawX, drawY, drawWidth, drawHeight, null);
	}

	public boolean contains(int x, int y) {
		return x > drawX && y > drawY && x < drawX + drawWidth
				&& y < drawY + drawHeight;
	}
}
