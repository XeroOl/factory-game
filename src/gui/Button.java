package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import file.ImageReader;

public class Button extends GuiElement {
	static Image buttonImage = ImageReader
			.getImage("assets/gui/menu/button.png");
	String myText;

	public Button(int x, int y, int width, int height, String text) {
		this.drawX = x;
		this.drawY = y;
		this.drawWidth = width;
		this.drawHeight = height;
		this.drawImage = buttonImage;
		this.myText = text;
	}

	public void click() {
		//System.out.println(myText);
	}

	public void drawImage(Graphics g) {
		super.drawImage(g);
		g.drawString(myText, drawX + drawWidth / 3, drawY + drawHeight / 2);
	}

	public void action() {
		// override this method when you declare the button variable
	}


}
