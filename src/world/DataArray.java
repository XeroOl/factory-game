package world;

import java.util.ArrayList;

public class DataArray extends ArrayList<Data> {
	public DataArray(String s) {
		int nestLevel = 0;
		int lastLoc = 0;
		boolean inComment = false;
		boolean inQuotes = false;
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (currentChar == '"') {
				inQuotes = !inQuotes;
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
					add(new Data(s.substring(lastLoc, i)));
					lastLoc = i + 1;
				}
			}
		}
		add(new Data(s.substring(lastLoc,s.length())));
	}
	public boolean verify(Class<?>... parameters){
		if(parameters.length==size()){
			for(int i = 0; i < parameters.length;i++){
				if(parameters[i]==int.class){
					
				}
				if(!parameters[i].isInstance(get(i).getClassType())){
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
