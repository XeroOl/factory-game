package world.item;

import main.Console;

public class ItemOne extends Item {
	String s;
public ItemOne(String data){
	s = data;
}
public void shout(){
	Console.console.info(s);
}
}
