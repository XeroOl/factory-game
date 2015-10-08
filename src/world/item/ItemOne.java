package world.item;

import world.Data;
import world.DataArray;

public class ItemOne extends Item {
	String s;
	Data[] values;

	public ItemOne(DataArray d) {
		if(d.verify(null,ItemOne.class,null)){
			System.out.println("hi");
		}
	}


	@Override
	public int getMaxCount() {
		return 50;
	}
}
