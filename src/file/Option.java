package file;

public class Option {
String name;
String val;
int id;
String[] allVals;
public Option(String name, String val, String[] allVals) {
	super();
	this.name = name;
	this.val = val;
	this.allVals = allVals;
	for(int i = 0; i<allVals.length;i++){
		if(val.equals(allVals[i])){
			id=i;
			break;
		}
	}
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getVal() {
	return val;
}
public void setVal(int id) {
	this.val = allVals[id];
	this.id=id;
}
public int getValId(){
	return id;
}
}
