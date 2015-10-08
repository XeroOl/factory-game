package render;

import gui.Layer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.event.MouseInputListener;

import main.Console;

public abstract class Scene implements MouseWheelListener, MouseInputListener {
	public ArrayList<Layer> layers = new ArrayList<Layer>();
	public GameScreen myScreen;
	long timeSinceMoved = System.currentTimeMillis();

	public abstract void leftClick(int x, int y);

	public abstract void rightClick(int x, int y);

	public abstract void middleClick(int x, int y);

	public abstract void scroll(int wheelRotation, int x, int y);

	public abstract void hover(int x, int y);

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case MouseEvent.BUTTON1:
			leftClick(e.getX(), e.getY());
			return;
		case MouseEvent.BUTTON2:
			rightClick(e.getX(), e.getY());
			return;
		case MouseEvent.BUTTON3:
			middleClick(e.getX(), e.getY());
			return;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll(e.getWheelRotation(), e.getX(), e.getY());
	}

}
