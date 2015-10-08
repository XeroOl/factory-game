package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import world.Data;
import world.DataArray;

public class SaveManager {
	String path;
	HashMap<String, Data[]> fileMap = new HashMap<String, Data[]>();
	public SaveManager(String path) {
		this.path = path;
		
	}

	public DataArray getContents(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path
					+ filename)));
			String fileContents = "";
			String line = "";
			while ((line = br.readLine()) != null)
				fileContents = fileContents + line;
			br.close();
			return new DataArray(fileContents);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
