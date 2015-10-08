package world;

import java.lang.reflect.InvocationTargetException;

import main.Console;

public class Data {
	String myString;
	String name;
	DataArray metaData;
	Class<?> myClass;

	public Data(String s) {
		myString = s;
		name = readName();
		metaData = readMetaData();
		myClass = readClassName();
	}

	public int toInt() {
		return Integer.parseInt(myString);
	}

	public boolean isInt() {
		try {
			Integer.parseInt(myString);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public double toDouble() {
		return Double.parseDouble(myString);
	}

	private boolean isDouble() {
		try {
			Double.parseDouble(myString);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public <T> T toType(Class<T> dataType) {
		try {
			return dataType.cast(myClass.getConstructor(DataArray.class)
					.newInstance(metaData));
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
			Console.console
					.error("Class " + name
							+ " does not contain the constructor " + name
							+ "(Data...)");
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String toString() {
		return myString;
	}

	public DataArray readMetaData() {
		try {
			String metaDataString = myString.split(":", 2)[1].substring(1,
					myString.length() - myString.indexOf(":") - 2);

			return new DataArray(metaDataString);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}

	}

	public String readName() {
		int i;
		try {
			return (myString.charAt(0) != '"' && (i = myString.indexOf(':')) != -1) ? myString
					.substring(0, i) : null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public String getName() {
		return name;
	}

	public DataArray getMetaData() {
		return metaData;
	}

	public Class getClassType() {
		return myClass;
	}

	public Class readClassName() {
		if (name != null) {
			if (isInt()) {
				return int.class;
			}
			if (isDouble()) {
				return double.class;
			}
			try {
				return Class.forName(name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
