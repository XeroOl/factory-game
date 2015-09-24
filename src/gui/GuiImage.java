package gui;

import java.awt.Image;

public class GuiImage extends GuiElement {
	public GuiImage(int x, int y, int width, int height, Image myImage) {
		drawImage=myImage;
		this.drawX=x;
		this.drawY=y;
		this.drawWidth=width;
		this.drawHeight=height;
	}
}
