package gui;

import java.util.ArrayList;

import render.DrawableObject;

public class Layer extends ArrayList<DrawableObject> {
	public void add(DrawableObject... addthese) {
		for (DrawableObject draw : addthese)
			add(draw);

	}

	public Layer() {
	}

	public Layer(DrawableObject... contents) {
		add(contents);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
