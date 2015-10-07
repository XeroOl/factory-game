package world;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import main.Console;

public class Data {
	String myValue;

	public Data(String s) {
		myValue = s;
	}

	public int toInt() {
		return Integer.parseInt(myValue);
	}

	public double toDouble() {
		return Double.parseDouble(myValue);
	}

	public <T> T toType(Class<T> dataType) {
		try {
			return dataType.cast(Class.forName(getName())
					.getConstructor(Data[].class)
					.newInstance((Object) getMetaData()));
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			Console.console.error("Invalid save file format:" + this);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			Console.console.error("Class " + getName()
					+ " does not contain the constructor " + getName()
					+ "(Data...)");
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			Console.console.error("Cannot find class file " + getName()
					+ ".class");
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String toString() {
		return myValue;
	}

	public Data[] getMetaData() {
		try {
			String meta = myValue.split(":", 2)[1].substring(1,
					myValue.length() - myValue.indexOf(":") - 2);
			ArrayList<Data> a = new ArrayList<Data>();
			int nestLevel = 0;
			int lastLoc = 0;
			boolean inComment = false;
			boolean inQuotes = false;
			for (int i = 0; i < meta.length(); i++) {
				char currentChar = meta.charAt(i);
				if (currentChar == '"') {
					inQuotes=!inQuotes;
				}
				if (!inQuotes) {
					if (currentChar == '{') {
						nestLevel++;
						inComment = true;
					} else if (inComment) {
						if (currentChar == '}') {
							inComment = --nestLevel != 0;
						}
					} else if (currentChar == ',') {
						a.add(new Data(meta.substring(lastLoc, i)));
						lastLoc = i + 1;
					}
				}
			}
			a.add(new Data(meta.substring(lastLoc, meta.length())));
			return a.toArray(new Data[a.size()]);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public String getName() {
		int i;
		return (myValue.charAt(0) != '"' && (i = myValue.indexOf(':')) != -1) ? myValue
				.substring(0, i) : null;
	}
}
