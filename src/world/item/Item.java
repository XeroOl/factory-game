package world.item;


public abstract class Item {
	int count;
	public abstract int getMaxCount();
public Item(int count){
	this.count = count;
}
}
