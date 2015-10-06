package world.item;

import java.lang.reflect.InvocationTargetException;

import main.Console;
import world.Data;
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
					.getConstructor(String[].class)
					.newInstance(
							(Object) StringParser.split(StringParser
									.getMetaData(data)));

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			Console.console.error("Invalid save file format:" + data);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			Console.console.error("Class " + StringParser.getName(data)
					+ " does not contain the constructor "
					+ StringParser.getName(data) + "(Data...)");
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			Console.console.error("Cannot find class file "
					+ StringParser.getName(data) + ".");
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	Item(Data... d) {

	}
}
