package world.item;

import main.Console;
import world.Data;

public class ItemOne extends Item {
	String s;
	Data[] values;

	public ItemOne(Data... d) {
		super(d[0].toInt());
	}


	@Override
	public int getMaxCount() {
		return 50;
	}
}
