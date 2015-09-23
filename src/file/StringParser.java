package file;

import java.util.ArrayList;

public class StringParser {
	public static String[] split(String string, char regex, char commentStart,
			char commentEnd) {
		ArrayList<String> a = new ArrayList<String>();
		int nestLevel = 0;
		int lastLoc = 0;
		boolean inComment = false;
		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);

			if (currentChar == commentStart) {
				nestLevel++;
				inComment = true;
			} else if (inComment) {
				if (currentChar == commentEnd) {
					inComment = --nestLevel != 0;
				}
			} else if (currentChar == regex) {
				a.add(string.substring(lastLoc, i));
				lastLoc = i + 1;
			}
		}
		a.add(string.substring(lastLoc, string.length()));
		return a.toArray(new String[a.size()]);
	}

	public static String getMetaData(String string) {
		try {
			return string.split(":", 2)[1].substring(1, string.length()
					- string.indexOf(":") - 2);
		} catch (IndexOutOfBoundsException e) {
			return "";
		}

	}
}
