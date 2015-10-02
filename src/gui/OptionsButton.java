package gui;

import file.Option;
import file.Options;

public class OptionsButton extends Button {
	String[] texts;
Option o;
	public OptionsButton(int x, int y, int width, int height, Option option,
			String[] displayNames) {
		super(x, y, width, height, displayNames[option.getValId()]);
		o= option;
		texts= displayNames;
	}

	public String toggle() {
		o.setVal(o.getValId()+1);
		return texts[o.getValId()];
	}
}
