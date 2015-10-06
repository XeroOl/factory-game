package world.item;

import main.Console;
import world.Data;

public class ItemOne extends Item {
	String s;
public ItemOne(String... d){
	for(int i = 0; i < d.length; i++){
		Console.console.debug(d[i]);
	}
}
public void shout(){
	Console.console.info(s);
}
}
