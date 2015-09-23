package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileEditor {
	String filename;
	String[] dataNames;
	String[] dataValues;

	public FileEditor(String filename) {
		this.filename = filename;
		try {
			Scanner s = new Scanner(new File(filename));
			String allTheData = "";
			while (s.hasNextLine())
				allTheData += s.nextLine() + "\0007";
			String[] data = allTheData.split("\0007");

			dataNames = new String[data.length];
			dataValues = new String[data.length];
			for (int i = 0; i < data.length; i++) {
				String[] temp = data[i].split("=");
				dataNames[i] = temp[0].trim();
				dataValues[i] = temp[1].trim();
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeVariable(String name, String d) {
	}

	public String readOption(String name) {
		String it = null;
		for (int i = 0; i < dataNames.length; i++) {
			if (name.equals(dataNames[i])) {
				it = dataValues[i];
			}
		}
		return it;
	}

	public void save() {
	}
	public String toString(){
		String s = filename + " :\n";
		for(int i = 0; i< dataNames.length;i++){
			s+=dataNames[i]+" = "+dataValues[i]+"\n";
		}
		return s;
	}
}
