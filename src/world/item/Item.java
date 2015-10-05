package world.item;

import java.lang.reflect.InvocationTargetException;

import file.StringParser;

public class Item {
	int count;
	int maxCount;

	public static Item fromString(String data) {
		try {
			return (Item) Class
					.forName(
							Item.class.getPackage().getName() + "."
									+ StringParser.getName(data))
					.getConstructor(String.class)
					.newInstance(StringParser.getMetaData(data));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	Item() {

	}
}
