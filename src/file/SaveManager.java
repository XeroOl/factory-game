package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SaveManager {
	String path;

	public SaveManager(String path) {
		this.path = path;
	}

	public String openFile(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path
					+ filename)));
			String fileContents = "";
			String line = "";
			while ((line = br.readLine()) != null)
				fileContents = fileContents + line;
			br.close();
			return fileContents;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
